package ir.shajarkar.controller.user;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.entity.Employee;
import ir.shajarkar.model.servcie.BonusEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.io.IOException;


@WebServlet("/api/bonus/purchase")
public class PurchaseBonusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final Long bonusId = Long.valueOf(req.getParameter("bonus_id"));
            final Employee user = (Employee) req.getSession().getAttribute("user");
            final Long employeeId = Long.valueOf(user.getId());
            Bonus bonus = new Bonus().setId(bonusId);
            Employee employee = new Employee().setId(employeeId);
            BonusEmployeeService.getInstance().purchaseBonus(employee, bonus);
            req.getRequestDispatcher("/api/bonus/showNotEmpty").forward(req, resp);
        } catch (ValidationException ex) {
            req.setAttribute("error", ex.getMessage());
            resp.sendError(700);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

