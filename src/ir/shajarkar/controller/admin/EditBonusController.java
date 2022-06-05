package ir.shajarkar.controller.admin;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.servcie.BonusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/bonus/edit")
public class EditBonusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            final Long bonusId = Long.valueOf(req.getParameter("id"));
            final Long number = Long.valueOf(req.getParameter("number"));
            final Long price = Long.valueOf(req.getParameter("price"));
            final String name = req.getParameter("name");
            Bonus bonus = new Bonus().setId(bonusId).setNumber(number).setPrice(price).setName(name);
            BonusService.getInstance().update(bonus);
            resp.sendRedirect("/api/bonus/show");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
