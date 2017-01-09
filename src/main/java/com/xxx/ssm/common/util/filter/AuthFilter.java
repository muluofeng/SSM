package com.xxx.ssm.common.util.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2016/11/18.
 */
public class AuthFilter  implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse res = (HttpServletResponse)servletResponse;
        //基于http协议的servlet

        //如果没有登录.
        String requestURI = req.getRequestURI().substring(req.getRequestURI().indexOf("/",1),req.getRequestURI().length());
        //如果第一次请求不为登录页面,则进行检查用session内容,如果为登录页面就不去检查.
        if(!"/login.html".equals(requestURI)&&!"/doLogin.html".equals(requestURI))
        {
            //取得session. 如果没有session则自动会创建一个, 我们用false表示没有取得到session则设置为session为空.
            HttpSession session = req.getSession(false);
            //如果session中没有任何东西.
            if(session == null ||session.getAttribute("pamAccount")==null)
            {
                res.sendRedirect(req.getContextPath() + "/admin/login.html");
                //返回
                return;
            }

        }
        //session中的内容等于登录页面, 则可以继续访问其他区资源.
        filterChain.doFilter(req, res);
    }
}
