package ir.shajarkar.controller;

import ir.shajarkar.model.entity.Employee;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestMonitor implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Employee user = (Employee) request.getSession().getAttribute("user");
        if (user != null && (request.getRequestURI().split("/")[1].trim().equals(user.getRole()))) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(403);
        }

    }

    @Override
    public void destroy() {

    }
}
