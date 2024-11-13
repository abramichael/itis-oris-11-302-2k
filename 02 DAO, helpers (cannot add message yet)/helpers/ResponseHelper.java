package org.example.zeroproject.helpers;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseHelper {
    public static void render(HttpServletResponse response, String out) {
        try {
            response.getWriter().println(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
