package com.sinewang.wave.jsm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by WangYanJiong on 10/24/14.
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
//        Object user = session.getAttribute("oscars-user");
//        if (user == null) {
//            String path = httpRequest.getRequestURI();
//            if (!path.equals("/sso")) {
//                if (!path.equals("/login")) {
//                    httpResponse.setStatus(302);
//                    return;
//                }
//            }
//        }
        filterChain.doFilter(request, response);
    }


    public void destroy() {

    }
}
