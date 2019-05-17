package denisenko.hw13.servlets;

import denisenko.hw13.dao.GoodDao;
import denisenko.hw13.model.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/addGood")
public class AddGoodServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String nameGoodHtml = request.getParameter("nameGood");
        String descriptionHtml = request.getParameter("description");
        double priceHtml = Double.parseDouble(request.getParameter("price"));
        GoodDao goodDao = new GoodDao();
        goodDao.addGood(new Good(priceHtml, nameGoodHtml, descriptionHtml));
        request.getRequestDispatcher("adminPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
