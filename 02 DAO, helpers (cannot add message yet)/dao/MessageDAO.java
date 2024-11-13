package org.example.zeroproject.dao;

import org.example.zeroproject.database.Database;
import org.example.zeroproject.models.Message;

import java.util.List;

public class MessageDAO implements DAO<Message> {
    @Override
    public void create(Message x) {

    }

    @Override
    public void update(Message x) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Message get(int id) {
        return null;
    }

    @Override
    public List<Message> getAll() {
        return Database.getMessages();
    }
}
