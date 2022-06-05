package ir.shajarkar.controller.admin;

import ir.shajarkar.model.entity.Bonus;
import ir.shajarkar.model.servcie.BonusService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/bonus/save")
public class BonusController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Bonus bonus = new Bonus()
                    .setName(req.getParameter("name"))
                    .setPrice(Integer.parseInt(req.getParameter("price")))
                    .setNumber(Integer.parseInt(req.getParameter("number")));
            BonusService.getInstance().save(bonus);
            resp.sendRedirect("/api/bonus/show");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
