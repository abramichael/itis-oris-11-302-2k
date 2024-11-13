package org.example.zeroproject.database;

import org.example.zeroproject.dao.MessageDAO;
import org.example.zeroproject.models.Message;
import org.example.zeroproject.models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Message> messages = new ArrayList<>();

    public static List<Message> getMessages() {
        return messages;
    }
}
