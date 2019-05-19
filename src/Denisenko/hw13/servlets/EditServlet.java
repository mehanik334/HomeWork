package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDaoHibernateImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {

    private static final UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    private static final Logger LOGGER = Logger.getLogger(EditServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Пароль изменен";
        Long idUser = Long.valueOf(request.getParameter("id"));
        String newPassword = request.getParameter("password");
        LOGGER.debug("Update user with id " + idUser + " and password " + newPassword);
        userDaoHibernate.updateUser(idUser, newPassword);
        request.setAttribute("message", message);
        LOGGER.debug("Forward to adminPage.jsp");
        request.getRequestDispatcher("adminPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        LOGGER.debug("Forward to edit.jsp");
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
}
