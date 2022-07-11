package com.example.add;

import java.sql.*;
import java.util.ArrayList;

public class Connections{
    private Connection dbConnection = null;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String ConnectionString = "jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1999_kursovaya";

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(ConnectionString, "std_1999_kursovaya", "12345678");

        return dbConnection;
    }


    public static ArrayList<Quotes> getQuotes() throws ClassNotFoundException, SQLException{
        ArrayList<Quotes> arr = new ArrayList<>();
        Connections connect = new Connections();
        Statement statement = connect.getDbConnection().createStatement();
        String select = "SELECT * FROM `Цитата`";
        try {
            ResultSet result = statement.executeQuery(select);
            while (result.next()) {
                arr.add(new Quotes(
                        result.getInt("id"),
                        result.getString("Текст"),
                        result.getString("Дата"),
                        result.getString("Предмет"),
                        result.getInt("id_пользователя"),
                        result.getString("Преподаватель")
                ));
            }
        } catch (Exception e) {}
        return arr;
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

    public void newQuotes(Quotes quotes){
        String insert = "INSERT INTO Цитата (Текст, Дата, Предмет, id_пользователя, Преподаватель) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(insert);
            values.setString(1, quotes.getText());
            values.setString(2, quotes.getDate());
            values.setString(3, quotes.getSubject());
            //values.setString(4, quotes.getUserId());
            values.setString(5, quotes.getTeacher());


            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void userID(String login, String password){

    }
}
