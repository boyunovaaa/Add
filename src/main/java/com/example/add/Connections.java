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
                        result.getString("id"),
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
        String insert = "INSERT INTO Пользователь (Логин, Пароль, Группа) VALUES(?,?,?)";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(insert);
            values.setString(1, user.getLogin());
            values.setString(2, user.getPassword());
            values.setString(3, user.getGroup());


            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user){
        ResultSet result = null;

        String select = "SELECT * FROM Пользователь WHERE Логин =? AND Пароль=?";

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

    public void newQuotes(String text, String date, String subject, int user_id, String teacher) throws ClassNotFoundException, SQLException{
        String insert = "INSERT INTO Цитата (Текст, Дата, Предмет, id_пользователя, Преподаватель) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(insert);
            values.setString(1, text);
            values.setString(2, date);
            values.setString(3, subject);
            values.setInt(4, user_id);
            values.setString(5, teacher);

            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteQuotes3(int id) throws ClassNotFoundException, SQLException{
        Connections connect = new Connections();
        Statement statement = connect.getDbConnection().createStatement();
        try {
        String query = String.format(
                "DELETE FROM `Цитата` " +
                        "WHERE `id`=%s",
                id
        );
            statement.executeUpdate(query);
        } catch (Exception e) {}
    }

    public static void deleteQuotes2(int id) throws ClassNotFoundException, SQLException{
        Connections connect = new Connections();
        Statement statement = connect.getDbConnection().createStatement();
        try {
            String query = String.format(
                    "DELETE FROM `Цитата` " +
                            "WHERE `id`=%s AND id_пользователя=%s",
                    id, UserQuotes.user.getId()
            );
            statement.executeUpdate(query);
        } catch (Exception e) {}
    }

    public static void deleteQuotes1(int id) throws ClassNotFoundException, SQLException{
        Connections connect = new Connections();
        Statement statement = connect.getDbConnection().createStatement();
        try {
            String query = String.format(
                    "DELETE FROM `Цитата` " +
                            "WHERE `id`=%s AND (SELECT `Группа` FROM `Пользователь` WHERE `id`=`id_пользователя` LIMIT 1) = %s",
                    id, UserQuotes.user.getGroup()
            );
            statement.executeUpdate(query);
        } catch (Exception e) {}
    }

    public void editQuotes3(Quotes quotes){

        String update = "UPDATE Цитата SET id=?, Текст=?, Дата=?, Предмет=?, id_пользователя=?, Преподаватель=? WHERE id=?";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(update);
            values.setString(1, quotes.getId());
            values.setString(2, quotes.getText());
            values.setString(3, quotes.getDate());
            values.setString(4, quotes.getSubject());
            values.setInt(5, quotes.getUserId());
            values.setString(6, quotes.getTeacher());
            values.setString(7, quotes.getId());

            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void editQuotes2(Quotes quotes) {

        String update = "UPDATE Цитата SET id=?, Текст=?, Дата=?, Предмет=?, id_пользователя=?, Преподаватель=? WHERE id=? AND id_пользователя=?";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(update);
            values.setString(1, quotes.getId());
            values.setString(2, quotes.getText());
            values.setString(3, quotes.getDate());
            values.setString(4, quotes.getSubject());
            values.setInt(5, quotes.getUserId());
            values.setString(6, quotes.getTeacher());
            values.setString(7, quotes.getId());
            values.setInt(8, UserQuotes.user.getId());

            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void editQuotes1(Quotes quotes) {

        String update = "UPDATE Цитата SET id=?, Текст=?, Дата=?, Предмет=?, id_пользователя=?, Преподаватель=? WHERE (id=? AND ((SELECT `Группа` FROM `Пользователь` WHERE `id`=`id_пользователя` LIMIT 1)=?))";

        try {
            PreparedStatement values = getDbConnection().prepareStatement(update);
            values.setString(1, quotes.getId());
            values.setString(2, quotes.getText());
            values.setString(3, quotes.getDate());
            values.setString(4, quotes.getSubject());
            values.setInt(5, quotes.getUserId());
            values.setString(6, quotes.getTeacher());
            values.setString(7, quotes.getId());
            values.setString(8, UserQuotes.user.getGroup());

            values.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int countQuotes() {
        try {
            Connections connect = new Connections();
            Statement statement = connect.getDbConnection().createStatement();

            String query = "SELECT COUNT(*) AS 'count' FROM `Цитата` " +
                    "WHERE `id_пользователя`=" + UserQuotes.user.getId();

            ResultSet res = statement.executeQuery(query);
            res.next();
            return res.getInt("count");
        } catch (Exception e) {}
        return 0;
    }

    public static ArrayList<Quotes> UsersStatus() {
        ArrayList<Quotes> arr = new ArrayList<>();

        try {
            Connections connect = new Connections();
            Statement statement = connect.getDbConnection().createStatement();
            String query = "";
            if (UserQuotes.user.getStatus() == 1) {
                query = String.format(
                        "SELECT * FROM `Цитата` " +
                                "WHERE `id_пользователя` = '%s'",
                        UserQuotes.user.getId()
                );
            }
            else if (UserQuotes.user.getStatus() == 2) {
                query = String.format(
                        "SELECT * FROM `Цитата` " +
                                "WHERE (SELECT `Группа` FROM `Пользователь` WHERE `id`=`id_пользователя` LIMIT 1) = %s",
                        UserQuotes.user.getGroup()
                );
            }
            else if (UserQuotes.user.getStatus() == 3) {
                query = String.format("SELECT * FROM `Цитата`");
            }
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                arr.add(new Quotes(
                        result.getString("id"),
                        result.getString("Text"),
                        result.getString("Date"),
                        result.getString("Subject"),
                        result.getInt("UserId"),
                        result.getString("Teacher")
                ));
            }
        } catch (Exception e) {}

        return arr;
    }
}
