package org.example.zeroproject.servlets;

import org.example.zeroproject.models.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SayServlet extends HttpServlet {
    private ArrayList<Message> messages = new ArrayList<>();
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println("<h1>Feedback</h1>");
            Object rawFlag = request.getSession().getAttribute("liked");
            if (rawFlag != null) {
                Boolean flag = (Boolean) rawFlag;
                if (flag) {
                    response.getWriter().println("<p>You like it.</p>");
                } else {
                    response.getWriter().println("<p>You do not like it.</p>");
                }
            } else {
                response.getWriter().println("<form method='POST' action='/like'>");
                response.getWriter().println("<select name='liked'>");
                response.getWriter().println("<option value='1'>Like</option>");
                response.getWriter().println("<option value='0'>Dislike</option>");
                response.getWriter().println("</select>");
                response.getWriter().println("<input type='submit' value='Send'/>");
                response.getWriter().println("</form>");
            }
            response.getWriter().println("<form method='POST'>");
            response.getWriter().println("<p><textarea name='txt'></textarea></p>");
            response.getWriter().println("<p><input type='submit' value='Yes, say it!'/></p>");
            response.getWriter().println("</form>");
            for (Message message : messages) {
                response.getWriter().println("<hr/");
                response.getWriter().println("<p><i>Posted on: " + message.getDate() + "</i></p>");
                response.getWriter().println("<p><b>" + message.getText() + "</b></p>");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String txt = request.getParameter("txt");
            messages.add(new Message(txt));
            response.sendRedirect("/say");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
