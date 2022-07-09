package com.example.add;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Connections{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String ConnectionString = "jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1999_kursovaya";

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(ConnectionString, "std_1999_kursovaya", "12345678");

        return dbConnection;
    }

    public void newUser(User user){
        String insert = "INSERT INTO Пользователь (Логин, Пароль) VALUES(?,?)";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(insert);
            values.setString(1, user.getLogin());
            values.setString(2, user.getPassword());

            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
