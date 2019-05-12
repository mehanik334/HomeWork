package denisenko.hw13;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/reg")
public class RegistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String login = req.getParameter("loginUser");
        String password = req.getParameter("loginPassword");
        if (login != null && password != null) {
            resp.getWriter().println("Пользователь " + login + " зарегестрирован");
        }
        Storage.USERS.add(new User(login, password));
    }
}