package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDao;
import denisenko.hw13.model.Role;
import denisenko.hw13.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/reg")
public class RegistServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();
    private static final Logger LOGGER = Logger.getLogger(RegistServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String message;
        String login = req.getParameter("loginUser");
        String password = req.getParameter("loginPassword");
        LOGGER.debug("Validate on null login and password");
        if (login != null && password != null) {
            LOGGER.debug("Add user to db");
            userDao.addUser(new User(login, password, Role.USER));
            message = "Поздравляем , " + login + ", вы зарегестрированы";
            req.setAttribute("message", message);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}