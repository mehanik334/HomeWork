package denisenko.hw13.servlets;

import denisenko.hw13.dao.GoodDao;
import denisenko.hw13.model.Good;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/goods")
public class GoodsServlet extends HttpServlet {

    private static final GoodDao goodDao = new GoodDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Good> allGoods = goodDao.getAllGoods().get();
        request.setAttribute("allGoods", allGoods);
        request.getRequestDispatcher("marketPlace.jsp").forward(request, response);
    }
}
