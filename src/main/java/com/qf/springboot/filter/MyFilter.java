package com.qf.springboot.filter;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author PanYouGEn
 * @Date 2019/10/21
 */
@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
    @Override
    public void destroy() {

    }
}
