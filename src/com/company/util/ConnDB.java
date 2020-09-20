package com.company.util;

import com.company.data.User;

import java.sql.*;
import java.util.ArrayList;

public class ConnDB {
    public static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void connect() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
    connection = DriverManager.getConnection(Variable.nameDB);
    System.out.println("База Подключена!");
    statement = connection.createStatement();
    }

    public static void createUser(String name, String lastName, String password) throws SQLException {
        statement.execute("INSERT INTO Users ('name', 'lastname', 'password') VALUES ('"+name+"','"+lastName+"','"+password+"'); ");
    }
    public static ArrayList<User> getUsers() throws SQLException {
        String s = "select * from users";
        resultSet = statement.executeQuery(s);
        ArrayList<User> users = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(resultSet.findColumn("id"));
            String name = resultSet.getString(resultSet.findColumn("name"));
            String lastname = resultSet.getString(resultSet.findColumn("lastname"));
            String password = resultSet.getString(resultSet.findColumn("password"));
            User user = new User(id, name, lastname, password);
            users.add(user);
        }
        return users;
    }

}
