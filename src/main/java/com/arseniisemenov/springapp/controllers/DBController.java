package com.arseniisemenov.springapp.controllers;

import com.arseniisemenov.springapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.PostConstruct;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DBController {
    @Autowired
    DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        System.out.println("DBController initialize: " + dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<User> queryAllUsers() {
        final String query = "SELECT * FROM USER ORDER BY ID";
        List<User> users = this.jdbcTemplate.query(query, new UserMapper());
        return users;
    }

    public User queryUser(int id) {
        final String query = "SELECT * FROM USER WHERE ID LIKE ?";
        User user = this.jdbcTemplate.queryForObject(query, new Object[]{id}, new UserMapper());
        return user;
    }

    public boolean addUser(final User user) {
        final String query = "INSERT INTO USER (NAME, PHONE, EMAIL, BLOG, NOTE) VALUES(?, ?, ?, ?, ?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPhone());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getBlog());
                preparedStatement.setString(5, user.getNote());
                return preparedStatement;
            }
        });
        return true;
    }

    public boolean updateUser(final User user) {
        final String query = "UPDATE USER SET NAME = ?, PHONE = ?, EMAIL = ?, BLOG = ?, NOTE = ? WHERE ID LIKE ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getPhone());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getBlog());
                preparedStatement.setString(5, user.getNote());
                preparedStatement.setInt(6, user.getId());
                return preparedStatement;
            }
        });
        return true;
    }

    public boolean deleteUser(int id) {
        final String query = "DELETE FROM USER WHERE ID LIKE ?";
        int result = jdbcTemplate.update(query, new Object[]{id});
        if(result > 0) {
            return true;
        }
        return false;
    }

    public List<User> findUsers(String name) {
        final String query = "SELECT * FROM USER WHERE NAME LIKE ?";
        List<User> users = this.jdbcTemplate.query(query, new Object[]{name}, new UserMapper());
        return users;
    }
}



class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("ID"));
        user.setName(resultSet.getString("NAME"));
        user.setPhone(resultSet.getString("PHONE"));
        user.setEmail(resultSet.getString("EMAIL"));
        user.setBlog(resultSet.getString("BLOG"));
        user.setNote(resultSet.getString("NOTE"));
        return user;
    }
}