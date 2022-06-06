package ir.shajarkar.controller.user;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.servcie.BonusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/bonus/showNotEmpty")
public class ShowNotEmptyBonusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final List<Bonus> capacityBonuses = BonusService.getInstance().getNotEmpty();
            req.setAttribute("bonuses", capacityBonuses);
            req.getRequestDispatcher("/user/bonuses.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}