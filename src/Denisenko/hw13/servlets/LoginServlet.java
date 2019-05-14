package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDao;
import denisenko.hw13.model.User;
import denisenko.hw13.utils.HashUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        String login = req.getParameter("loginUser");
        String password = req.getParameter("loginPassword");
        LOGGER.debug("Get user " + login + " from DB");
        User userDB = userDao.getUser(login).get();
        String passwordHash = HashUtils.getSHA512SecurePassword(password, userDB.getSalt());
        LOGGER.debug("Equals login and password user  from request");
        if (userDB.getPassword().equals(passwordHash) && userDB.getLogin().equals(login)) {
            req.getSession().setAttribute("user", userDB);
            LOGGER.debug("Verification " + login + " on role");
            if (userDB.getRole().getValue().equals("user")) {
                LOGGER.debug(login + " is user and forward to marketPlace.jsp");
                message = "Привет пользователь " + login;
                req.setAttribute("message", message);
                req.getRequestDispatcher("/goods").forward(req, resp);
            } else if (userDB.getRole().getValue().equals("admin")) {
                LOGGER.debug(login + " is admin and forward to adminPage.jsp");
                req.setAttribute("login", login);
                req.getRequestDispatcher("/admin").forward(req, resp);
            }
        }
    }
}