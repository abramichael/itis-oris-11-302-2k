package org.example.zeroproject.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter extends HttpFilter {

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) {
        try {
            if (req.getSession().getAttribute("user") != null) {
                chain.doFilter(req, resp);
            } else {
                resp.sendRedirect("/login?="+req.getRequestURI());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
