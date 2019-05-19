package denisenko.hw13.servlets;

import denisenko.hw13.dao.GoodDaoHibernateImpl;
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
        String nameGoodHtml = request.getParameter("nameGood");
        String descriptionHtml = request.getParameter("description");
        double priceHtml = Double.parseDouble(request.getParameter("price"));
        GoodDaoHibernateImpl goodDaoHibernate = new GoodDaoHibernateImpl();
        goodDaoHibernate.addGood(new Good(priceHtml, nameGoodHtml, descriptionHtml));
        request.getRequestDispatcher("adminPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
