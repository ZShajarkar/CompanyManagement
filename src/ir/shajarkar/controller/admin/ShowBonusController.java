package ir.shajarkar.controller.admin;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.servcie.BonusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/bonus/show")
public class ShowBonusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final List<Bonus> capacityBonuses = BonusService.getInstance().getAll();
            req.setAttribute("bonuses", capacityBonuses);
            req.getRequestDispatcher("/admin/bonuses.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}