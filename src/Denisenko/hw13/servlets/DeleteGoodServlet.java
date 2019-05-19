package denisenko.hw13.servlets;

import denisenko.hw13.dao.GoodDaoHibernateImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/deleteGood")
public class DeleteGoodServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(DeleteGoodServlet.class);
    private static final GoodDaoHibernateImpl goodDaoHibernate = new GoodDaoHibernateImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        LOGGER.debug("Delete good " + id);
        goodDaoHibernate.deleteGood(id);
        LOGGER.debug("Forward to adminPage.jsp");
        request.getRequestDispatcher("/AdminServlet").forward(request, response);
    }
}