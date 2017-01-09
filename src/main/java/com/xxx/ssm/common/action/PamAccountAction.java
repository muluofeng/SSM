package com.xxx.ssm.common.action;

import com.xxx.ssm.common.entities.AccountInfo;
import com.xxx.ssm.common.entities.PamAccount;
import com.xxx.ssm.common.entities.ResultData;
import com.xxx.ssm.common.entities.vo.AccountVO;
import com.xxx.ssm.common.services.AccountService;
import com.xxx.ssm.common.util.RequestUtil;
import com.xxx.ssm.common.util.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/18.
 */
@Controller
@RequestMapping("/admin/pamAccount")
public class PamAccountAction {
    @Autowired
    private AccountService accountService;

    @RequestMapping("index.html")
    public  String index(
            @RequestParam(value="pageNo",required = false) String pageNo,
            @RequestParam(value="pageNum",required = false) String pageNum,
            HttpServletRequest request){
        //获取所有的后台用户
        pageNum= StringUtils.isEmpty(pageNum) ? "10": pageNum;
        pageNo =StringUtils.isEmpty(pageNo)  ? "0" :pageNo;
        int pageStart=Math.max(0,(Integer.parseInt(pageNo)-1)*Integer.parseInt(pageNum));
        int  limit=Integer.parseInt(pageNum);
        HashMap  map=new HashMap();
        map.put("start",pageStart);
        map.put("limit",limit);
        List<AccountVO> accountVoList = accountService.getAccountVoList(map);
        request.setAttribute("accountVoList",accountVoList);
        return "admin/pamAccount/index";
    }


    @RequestMapping("add.html")
    public String addAccount(){
        return "admin/pamAccount/accountInfo";
    }

    @RequestMapping(value = "save.json",method = RequestMethod.POST)
    @ResponseBody
    public ResultData<List<String>> doSave(HttpServletRequest request) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ResultData<List<String>> resultData=new ResultData<List<String>>();
        PamAccount pamAccount=new PamAccount();
        AccountInfo accountInfo=new AccountInfo();
        HashMap<String,Object> dataMap= RequestUtil.getMapByRequest(request);
        String accountId= (String) dataMap.get("accountId");
        //验证数据
        HashMap  saveMap=new HashMap();
        int time=(int)(new Date().getTime()/1000);
        if(accountId==null){
            if(!dataMap.get("confirm_password").equals(dataMap.get("password"))){
                resultData.setSuccess(false);
                resultData.setMessage("2次密码不一致");
                return resultData;
            }
            HashMap map=new HashMap();
            map.put("login_name",(String)(dataMap.get("username")));
            AccountVO originalAccount= accountService.getAccountInfo(map);
            if(originalAccount!=null){
                resultData.setSuccess(false);
                resultData.setMessage("账号名称已经存在");
                return resultData;
            }
            //pamaccount
            pamAccount.setAccountType("admin");
            pamAccount.setDisabled("false");
            pamAccount.setLoginName((String)(dataMap.get("username")));
            pamAccount.setCreatetime(time);
            pamAccount.setLoginPassword(StringUtil.md5((String)(dataMap.get("password"))));
            //accountinfo
            accountInfo.setAddr((String)dataMap.get("addr"));
            accountInfo.setEmail((String)dataMap.get("email"));
            accountInfo.setSex((String)dataMap.get("sex"));
            accountInfo.setRegtime(time);
        }else{
            accountInfo.setAddr((String)dataMap.get("addr"));
            accountInfo.setEmail((String)dataMap.get("email"));
            accountInfo.setSex((String)dataMap.get("sex"));
            accountInfo.setAccountId(Integer.parseInt(accountId));

            pamAccount.setAccountId(Integer.parseInt(accountId));
            pamAccount.setAccountType("admin");
        }

        saveMap.put("pamAccount",pamAccount);
        saveMap.put("accountInfo",accountInfo);
        int flag= accountService.saveAccount(saveMap);
        if(flag!=1){
            resultData.setSuccess(false);
            resultData.setMessage("添加账号失败");
            return resultData;
        }else{
            resultData.setSuccess(true);
            resultData.setMessage("添加账号成功");
        }
        return resultData;
    }

    @RequestMapping("edit.html")
    public String eidtAccount(@RequestParam("accountId")Integer accountId, HttpServletRequest request){
        HashMap map=new HashMap();
        map.put("account_id",request.getParameter("accountId"));
        AccountVO account= accountService.getAccountInfo(map);
        request.setAttribute("account",account);
        return "admin/pamAccount/accountInfo";
    }

    @RequestMapping("delete.html")
    public String deleteAccount(@RequestParam("accountId")Integer accountId){
        accountService.deleteAccountById(accountId);
        return "redirect:/admin/pamAccount/index.html";
    }


}
