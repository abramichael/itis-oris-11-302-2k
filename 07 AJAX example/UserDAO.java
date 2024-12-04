package org.example.zeroproject.dao;

import org.example.zeroproject.database.ConnectionWrapper;
import org.example.zeroproject.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAO<User> {
    @Override
    public void create(User x) {

    }

    @Override
    public void update(User x) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public User get(String username) {
        Connection conn = ConnectionWrapper.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User get(String username, String password) {
        Connection conn = ConnectionWrapper.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from users where username = ? and password = ?"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getUsernamesByMask(String q) {
        Connection conn = ConnectionWrapper.getConnection();
        List<String> usernames = new ArrayList<>();
        try {
            PreparedStatement ps = null;
            ps = conn.prepareStatement(
                    "select username from users where username like ?");
            ps.setString(1, "%" + q + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usernames.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usernames;
    }
}
