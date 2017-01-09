package com.xxx.ssm.common.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/10/21.
 */
public class RequestUtil {
    /**
     * 将request里面的数据封装成一个map
     * @param request
     * @return
     */
    public static HashMap<String,Object> getMapByRequest(HttpServletRequest request){
        HashMap<String,Object>  map=new HashMap();
        Enumeration enumeration=request.getParameterNames();
        while(enumeration.hasMoreElements()){
            String name= (String) enumeration.nextElement();
            Object objValue=request.getParameter(name);
            if(objValue!=null&&!"".equals(objValue)){
                map.put(name,objValue);
            }
        }
        return map;

    }
}
