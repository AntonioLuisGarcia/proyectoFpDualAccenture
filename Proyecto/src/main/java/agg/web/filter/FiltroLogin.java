package agg.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

@WebFilter(filterName = "FiltroLogin", urlPatterns = {"index.jsp"})
public class FiltroLogin implements Filter {

    /**
     * Inicialización del filtro
     * @param filterConfig - FilterConfig
     * @throws ServletException
     */

    public void init(FilterConfig filterConfig) throws ServletException {
    }


    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        if (req.getSession().getAttribute("userLogin") == null) {
            ((HttpServletResponse)servletResponse).sendRedirect("/index.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
