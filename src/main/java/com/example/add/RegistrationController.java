package com.example.add;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button checkButton;

    @FXML
    void initialize() {
        checkButton.setOnAction(actionEvent -> {
            newUser();
        });
    }

    private void newUser() {
        Connections connect = new Connections();

        String login = loginField.getText();
        String password = passwordField.getText();

        User user = new User(login, password);

        connect.newUser(user);
    }
}
