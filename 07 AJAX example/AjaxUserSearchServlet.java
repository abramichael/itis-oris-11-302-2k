package org.example.zeroproject.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.zeroproject.dao.UserDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AjaxUserSearchServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            List<String> usernames = userDAO.getUsernamesByMask(request.getParameter("q"));
            String result = objectMapper.writeValueAsString(usernames);

            response.getWriter().println(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}