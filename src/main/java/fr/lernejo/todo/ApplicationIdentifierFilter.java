package fr.lernejo.todo;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


@Component
public class ApplicationIdentifierFilter implements Filter {

    String uuid = UUID.randomUUID().toString();

    /**
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletResponse httpServletResponse){
            httpServletResponse.setHeader("Instance-Id", this.uuid);
        }
    }

    /**
     *
     */
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
