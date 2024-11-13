package org.example.zeroproject.helpers;

import org.example.zeroproject.models.Message;

import java.util.List;

public class MessageHelper {
    public String renderToHTML(List<Message> messages) {
        String result = "";
        for (Message message : messages) {
            result += "<hr/";
            result += "<p><i>Posted on: " + message.getDate() + "</i></p>";
            result += "<p><b>" + message.getText() + "</b></p>";
        }
        return result;
    }

}
