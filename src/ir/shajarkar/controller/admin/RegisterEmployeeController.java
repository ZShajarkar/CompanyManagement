package ir.shajarkar.controller.admin;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.entity.Employee;
import ir.shajarkar.model.servcie.BonusService;
import ir.shajarkar.model.servcie.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/employee/save")
public class RegisterEmployeeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Employee employee = new Employee()
                    .setFirstName(req.getParameter("firstName"))
                    .setLastName(req.getParameter("lastName"))
                    .setCode(req.getParameter("code"))
                    .setUsername(req.getParameter("username"))
                    .setPassword(req.getParameter("pass"))
                    .setRole(req.getParameter("role"));
            EmployeeService.getInstance().register(employee);
            resp.sendRedirect("/admin");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
