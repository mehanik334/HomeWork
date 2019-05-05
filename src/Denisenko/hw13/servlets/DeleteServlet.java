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

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = response.getWriter();
        String login = request.getParameter("login");
        userDao.deleteUser(new User(login));
        printWriter.println("Пользователь успешно удален!!!");
    }
}
