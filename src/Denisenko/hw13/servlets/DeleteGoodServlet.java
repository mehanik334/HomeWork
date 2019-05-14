package denisenko.hw13.servlets;

import denisenko.hw13.dao.GoodDao;
import denisenko.hw13.model.Good;
import denisenko.hw13.model.User;
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
    private static final GoodDao goodDao = new GoodDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        LOGGER.debug("Delete good " + id);
        Good deleteGood = goodDao.getGoodByID(id).get();
        goodDao.deleteGood(deleteGood);
        LOGGER.debug("Forward to adminPage.jsp");
        request.getRequestDispatcher("/AdminServlet").forward(request, response);
    }
}
