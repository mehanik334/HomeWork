package denisenko.hw13.servlets;

import denisenko.hw13.dao.UserDao;
import denisenko.hw13.model.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {

    private static final UserDao userDao = new UserDao();
    private static final Logger LOGGER = Logger.getLogger(DeleteServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Пользователь успешно удален!!!";
        Long idUser = Long.parseLong(request.getParameter("id"));
        LOGGER.debug("Delete user " + idUser);
        userDao.deleteUser(idUser);
        request.setAttribute("message", message);
        LOGGER.debug("Forward to adminPage.jsp");
        request.getRequestDispatcher("/AdminServlet").forward(request, response);
    }
}
