package denisenko.hw13.servlets;

import denisenko.hw13.dao.CodeDaoHibernateImpl;
import denisenko.hw13.model.Code;
import denisenko.hw13.model.User;
import denisenko.hw13.service.MailService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/buy")
public class BuyGoodServlet extends HttpServlet {

    private static final MailService mailService = new MailService();
    public static final CodeDaoHibernateImpl codeDaoHibernate = new CodeDaoHibernateImpl();
    private static final Logger LOGGER = Logger.getLogger(BuyGoodServlet.class);


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long goodId = Long.valueOf(request.getParameter("good_id"));
        String codeValue = request.getParameter("code");
        User user = (User) request.getSession().getAttribute("user");
        Code code = new Code(user.getId(), goodId, codeValue);
        if (codeDaoHibernate.checkCode(code)) {
            response.getWriter().println("Оплата прошла");
            LOGGER.debug("Payment done");
        } else {
            response.getWriter().println("Оплата не прошла");
            LOGGER.debug("Payment dont");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idGood = Long.parseLong(request.getParameter("id"));
        User user = (User) request.getSession().getAttribute("user");
        String randomCode = mailService.sendMailWithCode(user.getEmail());
        Code code = new Code(user.getId(), idGood, randomCode);
        codeDaoHibernate.addGood(code);
        LOGGER.debug("Add code " + code + " to DB");
        request.setAttribute("good_id", idGood);
        request.getRequestDispatcher("buyConfirm.jsp").forward(request, response);
    }
}
