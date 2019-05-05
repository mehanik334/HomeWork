package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDao;
import denisenko.hw13.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String message;
        PrintWriter out = resp.getWriter();
        String login = req.getParameter("loginUser");
        String password = req.getParameter("loginPassword");
        User userDB = userDao.getUser(login, password);
        if (userDB.getPassword().equals(password) && userDB.getLogin().equals(login)) {

            message = "Добро пожаловать ";
            req.setAttribute("message", message);
            req.getRequestDispatcher("homePage.jsp").forward(req, resp);
        } else {
            out.println("Неправильно введен логин или пароль");
        }
    }
}