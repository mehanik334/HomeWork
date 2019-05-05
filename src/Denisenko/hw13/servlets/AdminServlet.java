package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDao;
import denisenko.hw13.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/admin")
public class AdminServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Привет администратор " + request.getParameter("login");
        request.setAttribute("message", message);
        List<User> users = userDao.getAllUsers().get();
        request.setAttribute("users", users);
        request.getRequestDispatcher("adminPage.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
