package com.example.add;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    void initialize() {
        checkButton.setOnAction(actionEvent -> {
            System.out.println("Вы нажали кнопку 'Войти'");
        });
    }
}
