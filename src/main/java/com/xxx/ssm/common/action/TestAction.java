package com.xxx.ssm.common.action;

import com.mangofactory.swagger.annotations.ApiIgnore;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.xxx.ssm.common.entities.ResultData;
import com.xxx.ssm.common.entities.SimpleEntity;
import com.xxx.ssm.common.entities.ValidationResult;
import com.xxx.ssm.common.entities.category;
import com.xxx.ssm.common.entities.example.categoryExample;
import com.xxx.ssm.common.entities.vo.AccountVO;
import com.xxx.ssm.common.services.CategoryService;
import com.xxx.ssm.common.services.imp.AccountServiceImp;
import com.xxx.ssm.common.util.RequestUtil;
import com.xxx.ssm.common.util.ValidationUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/10/13.
 */
@Controller
@RequestMapping("/test")
@Api(value = "test") //写在contrller的@api注释是swagger用于将api分组，切记不要用中文，否则无法生成出文档
public class TestAction {

    @Autowired
    private CategoryService categoryServiceImp;
    @Autowired
    private AccountServiceImp accountServiceImp;

    private static Logger logger= LogManager.getLogger(TestAction.class.getName());

    @RequestMapping("test1")
    public String test(HttpServletRequest request){
        categoryExample example=new categoryExample();
        example.or().andCatnameEqualTo("muluofeng");
        List<category> categoryList=categoryServiceImp.getCategoryByName(example);
        request.setAttribute("categoryList",categoryList);


        //测试RequestUtil
        HashMap<String,Object> map= RequestUtil.getMapByRequest(request);

        //测试一下validation
        SimpleEntity simpleEntity=new SimpleEntity();
        simpleEntity.setDate(new Date());
        simpleEntity.setEmail("123");
        ValidationResult result= ValidationUtils.validateEntity(simpleEntity);
        System.out.println("--------------------------");
        System.out.println(result);
        System.out.println(result.getErrorMsg());

        request.setAttribute("mapData",map);
//        pamAccountExample accountExample=new pamAccountExample();
//        accountExample.or().andLoginNameEqualTo("pamAccountExample");
        return "test";
    }


    @RequestMapping("json")
    @ResponseBody
    public ResultData<List<String>> getJson(){
        ResultData<List<String>> resultData=new ResultData<List<String>>();
        List list=new ArrayList<String>();
        list.add("xxx-1");
        list.add("xxx-2");
        resultData.setCode("123");
        resultData.setMessage("muluofeng");
        resultData.setSuccess(true);
        resultData.setData(list);
        return resultData;
    }
    @RequestMapping("mybatis")
    @ResponseBody
    public ResultData<AccountVO> getJson2(){
        ResultData<AccountVO> resultData=new ResultData<AccountVO>();
        HashMap map=new HashMap<String,Object>();
        map.put("login_name","xxx@qq.com");
        AccountVO accountInfo= accountServiceImp.getAccountInfo(map);
//        AccountVO accountInfo=new AccountVO();
        resultData.setCode("123");
        resultData.setMessage("muluofeng");
        resultData.setSuccess(true);
        resultData.setData(accountInfo);
        logger.trace("log trace");
        logger.error("loginfoxxxx");
        return resultData;
    }

    @RequestMapping(value = "/swagger")
    @ApiOperation(value = "登陆") //value可以写中文
    @ResponseBody
    public ResultData<List<String>> swaggerTest(@ApiIgnore ModelMap modelMap //@apiignore表示忽略这个参数的输入，当然我们不需要客户端提交这个值
            , HttpServletRequest request
            , @ApiParam(required = true,value = "用户名")@RequestParam String username
            , @ApiParam(required = true,value = "密码")@RequestParam String pwd){
        ResultData<List<String>> resultData=new ResultData<List<String>>();
        List list=new ArrayList<String>();
        list.add("xxx-1");
        list.add("xxx-2");
        resultData.setCode("123");
        resultData.setMessage("muluofeng");
        resultData.setSuccess(true);
        resultData.setData(list);
        return resultData;
    }
}
