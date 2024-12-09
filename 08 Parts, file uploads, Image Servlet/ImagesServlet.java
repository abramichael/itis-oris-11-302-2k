package org.example.zeroproject.servlets;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class ImagesServlet extends HttpServlet {
    private final String imageRootPath = "c:\\d\\dev\\images\\";

    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        System.out.println("in images servlet");

        try {
            String filename = req.getParameter("image_name");
            File file = new File(imageRootPath + filename);

            res.setContentType("image/jpeg");
            //res.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            res.setContentLength((int) file.length());
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream inputStream = new BufferedInputStream(fileInputStream);
            ServletOutputStream outputStream = res.getOutputStream();;
            int readBytes = 0;
            while ((readBytes = inputStream.read()) != -1)
                outputStream.write(readBytes);
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
