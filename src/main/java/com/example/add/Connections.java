package com.example.add;

import java.sql.*;

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

    public ResultSet getUser(User user){
        ResultSet result = null;

        String select = "SELECT * FROM Пользователь WHERE Логин =? AND Пароль =?";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(select);
            values.setString(1, user.getLogin());
            values.setString(2, user.getPassword());

            result = values.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void changeUser(User user){
        String update = "UPDATE Пользователь SET Пароль=? WHERE Логин=? AND Пароль=?";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(update);
            values.setString(1, user.getNewPass());
            values.setString(2, user.getLogin());
            values.setString(3, user.getPassword());

            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
