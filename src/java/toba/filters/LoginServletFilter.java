package toba.filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServletFilter implements Filter {

    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ServletContext sc = filterConfig.getServletContext();
        
        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();
        
        sc.log(filterName + " | " + servletPath + " | before request");
        chain.doFilter(httpRequest, httpResponse);
        sc.log(filterName + " | " + servletPath + " | after request");
    }
    
    @Override
    public void destroy() {
        filterConfig = null;
    }
}
