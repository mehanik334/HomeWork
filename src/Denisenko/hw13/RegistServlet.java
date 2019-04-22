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
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE HTML>");
        out.println("<html>\n" +
                "  <head>\n" +
                "    <title>Регистрация</title>\n" +
                "  </head>\n" +
                "  <body>\n");
        out.println("<form action = \"/reg/done\" method=\"post\">");
        out.println("Введите логин");
        out.println("<input type=\"text\" name=\"loginUser\"/>");
        out.println("Введите пароль");
        out.println("<input type=\"text\" name=\"loginPassword\"/>");
        out.println("<input type = \"submit\" value = \" Регистрация\">");
        out.println("</form>");
        out.println("</body>\n" +
                "</html>\n");

    }
}
