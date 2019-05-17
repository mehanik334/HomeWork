package denisenko.hw13.filter;

import denisenko.hw13.model.Role;
import denisenko.hw13.model.User;
import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/admin","/addGood","/deleteGood","/delete","/edit"})
public class AdminFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(AdminFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        User user = (User) request.getSession().getAttribute(Role.USER.getValue());
        LOGGER.debug("User with login" + user.getLogin() + "try come as admin");
        if (user != null && user.getRole().equals(Role.ADMIN)) {
            filterChain.doFilter(servletRequest, servletResponse);
            LOGGER.debug("User with login" + user.getLogin() + " is admin");
        } else {
            LOGGER.debug("User with login" + user.getLogin() + "isnt admin");
            request.getRequestDispatcher("accessDenied.jsp").forward(request, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
