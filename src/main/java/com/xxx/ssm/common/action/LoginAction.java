package com.xxx.ssm.common.action;

import com.xxx.ssm.common.entities.AccountSession;
import com.xxx.ssm.common.entities.vo.AccountVO;
import com.xxx.ssm.common.services.imp.AccountServiceImp;
import com.xxx.ssm.common.util.SessionKeysUtil;
import com.xxx.ssm.common.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/14.
 */
@Controller
@RequestMapping("/admin")
public class LoginAction {

    @Autowired
    private AccountServiceImp accountServiceImp;

    @RequestMapping("login.html")
    public  String  login(HttpServletRequest request){

        String  loginUrl="admin/login";
        String  indexUrl="redirect:/admin/index.html";
        AccountSession session= (AccountSession) request.getSession().getAttribute(SessionKeysUtil.PAMACCOUNT);
        if(null==session){
            return loginUrl;
        }
            AccountVO accountVO=session.getAccountData();
        if(null==accountVO){
            return loginUrl;
        }else{
            return indexUrl;
        }
    }

    @RequestMapping(value = "doLogin.html",method = RequestMethod.POST)
    public String doLogin(
            @RequestParam(value="account",required = true)String account,
            @RequestParam(value = "password",required = true)String password,
            HttpServletRequest request){
        String url="/admin/login";
        //验证账号密码
        if(StringUtils.isEmpty(account)||StringUtils.isEmpty(password)){
            request.setAttribute("msg","账号和密码不能为空");
            return url;
        }
        HashMap map=new HashMap();
        map.put("login_name",account);
        AccountVO accountVO = accountServiceImp.getAccountInfo(map);
        if(accountVO==null){
            request.setAttribute("msg","账号或者密码不正确");
            return url;
        }
        String md5Password=null;
        try {
            md5Password= StringUtil.md5(password);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if(!accountVO.getLoginPassword().equals(md5Password)){
            request.setAttribute("msg","账号或者密码不正确");
            return url;
        }

        //设置session
        AccountSession session=setSession(accountVO);
        request.getSession().setAttribute(SessionKeysUtil.PAMACCOUNT,session);

        //跳转到index
        return "redirect:/admin/index.html";
    }

    /**
     * 后台登录首页
     * @param request
     * @return
     */
    @RequestMapping("index.html")
    public String index(HttpServletRequest request){
        if(!checkAccountSession(request)){
            return "redirect:/admin/login.html";
        }
        return "admin/index";
    }

    @RequestMapping("logout.html")
    public  String logout(HttpServletRequest request){
        //清除session
        HttpSession httpSession=request.getSession();
        AccountSession session= (AccountSession) request.getSession().getAttribute(SessionKeysUtil.PAMACCOUNT);
        httpSession.invalidate();
        return "redirect:/admin/login.html";
    }
    /**
     * 设置用户登录后的session
     * @param account
     * @return  AccountSession
     */
    private AccountSession setSession(AccountVO account) {
        AccountSession session=new AccountSession();
        session.setAccountData(account);
        //... ... 可以添加一些其他的数据，比如权限等等,暂时只写入AccountVO的数据
        return session;
    }

    private boolean checkAccountSession(HttpServletRequest request){
        AccountSession session= (AccountSession) request.getSession().getAttribute(SessionKeysUtil.PAMACCOUNT);
        if(session==null){
            return false;
        }
        AccountVO accountVO=session.getAccountData();
        if(accountVO==null){
            return false;
        }else{
            return true;
        }
    }

}
