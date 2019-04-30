package denisenko.hw13;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(value = "/login/valid")
public class ValidLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();
        String login = req.getParameter("loginUser");
        String password = req.getParameter("loginPassword");
        boolean flag = false;
        for (int i = 0; i < Storage.users.size(); i++) {
            User regUser = Storage.users.get(i);
            if (login.equals(regUser.getLogin()) && password.equals(regUser.getPassword())) {

                out.println("Привет " + Storage.users.get(i).getLogin());
                flag = true;
            }
        }
        if (!flag) {

            out.println("Неверный логин или пароль");
        }
        out.println();
    }
}
