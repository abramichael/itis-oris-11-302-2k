package org.example.zeroproject.servlets;

import freemarker.template.*;
import org.example.zeroproject.dao.MessageDAO;
import org.example.zeroproject.helpers.FreemarkerConfigSingleton;
import org.example.zeroproject.helpers.MessageHelper;
import org.example.zeroproject.models.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.example.zeroproject.helpers.ResponseHelper.render;

public class SayServlet extends HttpServlet {
    private MessageDAO messageDAO = new MessageDAO();
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            Object rawFlag = request.getSession().getAttribute("liked");
            int liked = 2;
            if (rawFlag != null) {
                Boolean flag = (Boolean) rawFlag;
                liked = flag ? 1 : 0;
            }
            Configuration cfg = FreemarkerConfigSingleton.getCfg(request);

            Map<String, Object> context = new HashMap<>();
            context.put("liked", liked);
            context.put("messages", messageDAO.getAll());

            Template template = cfg.getTemplate("say.ftl");

            try {
                template.process(context, response.getWriter());
            } catch (TemplateException e) {
                throw new RuntimeException(e);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String txt = request.getParameter("txt");
            messageDAO.create(new Message(txt));
            response.sendRedirect("/say");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
