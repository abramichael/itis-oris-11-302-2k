package org.example.zeroproject.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LikeServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        if (request.getSession().getAttribute("liked") == null) {
            String liked = request.getParameter("liked");
            Boolean flag = liked.equals("1");
            request.getSession().setAttribute("liked", flag);
        }
        try {
            response.sendRedirect("/say");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
