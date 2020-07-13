package com.eric.springdemo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * filter过滤器，在FilterConfig中注册
 */
public class XssFilter extends HttpFilter {
    private Logger log = LoggerFactory.getLogger(XssFilter.class);

    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.debug("XssFilter start!");
        chain.doFilter(request, response);
    }
}
