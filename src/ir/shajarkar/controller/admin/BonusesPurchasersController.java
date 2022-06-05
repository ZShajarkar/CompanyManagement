package ir.shajarkar.controller.admin;

import ir.shajarkar.model.entity.BonusEmployee;
import ir.shajarkar.model.servcie.BonusEmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/bonus/show-bonuses-purchasers")
public class BonusesPurchasersController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            BonusEmployeeService bonusEmployeeService = BonusEmployeeService.getInstance();
            final List<BonusEmployee> bonusesPurchasers = bonusEmployeeService.getAll();
            req.setAttribute("bonusesPurchasers",bonusesPurchasers);
            req.getRequestDispatcher("/admin/bonusesPurchasers.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
