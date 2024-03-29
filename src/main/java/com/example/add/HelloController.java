package com.example.add;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button newUserButton;

    @FXML
    private Button checkButton;

    @FXML
    private Button showButton;

    @FXML
    void initialize() {
        checkButton.setOnAction(actionEvent -> {
            String TextLogin = loginField.getText().trim();
            String TextPass = passwordField.getText().trim();

            UserLogin(TextLogin, TextPass);
        });

        newUserButton.setOnAction(actionEvent -> {
            newUserButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("registration.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent source = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(source));
            stage.show();
        });

        showButton.setOnAction(actionEvent -> {
            showButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("sawQuotes.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent source = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(source));
            stage.show();
        });
    }

    private void UserLogin(String textLogin, String textPass) {
        Connections connect = new Connections();
        User user = new User();

        user.setLogin(textLogin);
        user.setPassword(textPass);
        ResultSet result = connect.getUser(user);

        try {
            result.next();
                UserQuotes.user = new User(
                        result.getInt("id"),
                        result.getString("Логин"),
                        result.getString("Пароль"),
                        result.getString("Группа"),
                        result.getInt("Статус")
                );

        } catch (Exception e) {;}

        ResultSet result2 = connect.getUser(user);
        int counter = 0;
        while (true){
            try {
                if (!result2.next()){
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        if (counter >= 1){
            checkButton.setOnAction(actionEvent -> {
                checkButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("quotes.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent source = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(source));
                stage.show();
            });
        }
        else {
            checkButton.setOnAction(actionEvent -> {
                checkButton.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("error.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent source = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(source));
                stage.show();
            });
        }

    }
}
