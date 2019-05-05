package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDao;
import denisenko.hw13.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message;
        String login = req.getParameter("loginUser");
        String password = req.getParameter("loginPassword");
        User userDB = userDao.getUser(login, password).get();
        if (userDB.getPassword().equals(password) && userDB.getLogin().equals(login)) {
            req.getSession().setAttribute("user", userDB);
            if (userDB.getRole().equals("user")) {
                message = "Привет пользователь " + login;
                req.setAttribute("message", message);
                req.getRequestDispatcher("userPage.jsp").forward(req, resp);
            } else if (userDB.getRole().equals("admin")) {
                req.setAttribute("login", login);
                req.getRequestDispatcher("/admin").forward(req, resp);
            }
        }
    }
}