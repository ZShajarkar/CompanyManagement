package ir.shajarkar.controller;

import ir.shajarkar.model.entity.Employee;
import ir.shajarkar.model.servcie.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee user = new Employee();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        try {
           user= EmployeeService.getInstance().login(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/" + user.getRole());
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/WEB-INF/index.jsp");
        }
    }
}
