package com.company;

import com.company.data.User;
import com.company.util.ConnDB;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnDB.connect();
        ConnDB.createUser("Ivan", "Ivanov", "qwerty" );
        ConnDB.createUser("Petr", "Petrov", "ytrewq" );
        ConnDB.createUser("Vasja", "Vasin", "123qwe" );
        ArrayList<User> users = ConnDB.getUsers();
        for (User user: users) {
         System.out.println(" id " + user.getId() + " name " + user.getName() + " lastname " + user.getLastName() + " password " + user.getPassword());
        }
    }
}
