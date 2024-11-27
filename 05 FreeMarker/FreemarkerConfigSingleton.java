package org.example.zeroproject.helpers;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class FreemarkerConfigSingleton {
    private static Configuration cfg;
    private static ServletContext sc;
    public static Configuration getCfg(HttpServletRequest request) {
        if (cfg == null) {
            cfg = new Configuration();
            cfg.setServletContextForTemplateLoading(request.getServletContext(), "/WEB-INF/templates");

            // Some other recommended settings:
            cfg.setIncompatibleImprovements(new Version(2, 3, 33));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        }
        return cfg;
    }
}
