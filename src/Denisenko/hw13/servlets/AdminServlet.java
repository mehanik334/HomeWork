package denisenko.hw13.servlets;

import denisenko.hw13.dao.GoodDao;
import denisenko.hw13.dao.GoodDaoHibernateImpl;
import denisenko.hw13.dao.UserDao;
import denisenko.hw13.dao.UserDaoHibernateImpl;
import denisenko.hw13.model.Good;
import denisenko.hw13.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/admin")
public class AdminServlet extends HttpServlet {

    private static final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    private static final GoodDaoHibernateImpl goodDaohibenate = new GoodDaoHibernateImpl();

    private static final Logger LOGGER = Logger.getLogger(AdminServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Good> allGoods = goodDaohibenate.getAllGoods();
        String message = "Привет администратор " + request.getParameter("login");
        request.setAttribute("allGoods", allGoods);
        request.setAttribute("message", message);
        LOGGER.debug("Get all users from DB and add to request");
        List<User> users = userDaoHibernate.getAllUsers();
        request.setAttribute("users", users);
        LOGGER.debug("Forward to adminPage.jsp");
        request.getRequestDispatcher("adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
