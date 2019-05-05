package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDao;
import denisenko.hw13.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/reg")
public class RegistServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String message;
        String login = req.getParameter("loginUser");
        String password = req.getParameter("loginPassword");
        if (login != null && password != null) {
            userDao.addUser(new User(login, password, "user"));
            message = "Поздравляем , " + login + ", вы зарегестрированы";
            req.setAttribute("message", message);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}