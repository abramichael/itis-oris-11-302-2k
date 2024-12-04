package org.example.zeroproject.servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.example.zeroproject.dao.UserDAO;
import org.example.zeroproject.helpers.FreemarkerConfigSingleton;
import org.example.zeroproject.models.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchUsers extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Template t = null;
        try {
            t = FreemarkerConfigSingleton.getCfg(request).getTemplate("search.ftl");
            t.process(null, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
