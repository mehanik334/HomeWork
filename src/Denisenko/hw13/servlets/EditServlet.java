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

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Пароль изменен";
        String login = request.getParameter("login");
        String newPassword = request.getParameter("password");
        userDao.updateUser(new User(login),newPassword);
        request.setAttribute("message",message);
        request.getRequestDispatcher("homePage.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("login", request.getParameter("login"));
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
