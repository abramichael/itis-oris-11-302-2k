package org.example.zeroproject.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.zeroproject.dao.UserDAO;
import org.example.zeroproject.helpers.FreemarkerConfigSingleton;
import org.example.zeroproject.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@MultipartConfig
public class UserProfileServlet extends HttpServlet {

    private UserDAO userDAO = new UserDAO();
    private final String imageRootPath = "c:\\d\\dev\\images\\";

    public void doGet(HttpServletRequest req, HttpServletResponse res) {

        Template t = null;
        try {

            t = FreemarkerConfigSingleton.getCfg(req).getTemplate("profile.ftl");
            Map<String, Object> context = new HashMap<>();
            int user_id = ((User) req.getSession().getAttribute("user")).getId();
            User user = userDAO.get(user_id);
            context.put("user", user);
            t.process(context, res.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        try {
            Collection<Part> parts = req.getParts();
            User user = (User) req.getSession().getAttribute("user");
            if (!parts.isEmpty()) {
                Part part = parts.iterator().next();
                String filename =
                        "" + System.nanoTime() + part.getSubmittedFileName();
                part.write(imageRootPath + filename);
                user.setPhotoURL(filename);
                userDAO.update(user);
            }
            res.sendRedirect("/profile");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}
