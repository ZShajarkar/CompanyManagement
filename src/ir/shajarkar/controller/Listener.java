package ir.shajarkar.controller;

import ir.shajarkar.model.entity.Employee;
import ir.shajarkar.model.servcie.EmployeeService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final String adminPassword = servletContextEvent.getServletContext().getInitParameter("admin-password");
        final String adminUsername = servletContextEvent.getServletContext().getInitParameter("admin-username");
        Employee admin = new Employee().setPassword(adminPassword).setUsername(adminUsername).setRole("admin");
        try {
            EmployeeService.getInstance().register(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
