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
    void initialize() {

        checkButton.setOnAction(actionEvent -> {
            String TextLogin = loginField.getText().trim();
            String TextPass = passwordField.getText().trim();

            if(!TextLogin.equals("") && !TextPass.equals("")){
                UserLogin(TextLogin, TextPass);
            }
            else{
                System.out.println("Error");
            }
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
            stage.showAndWait();
        });
    }

    private void UserLogin(String textLogin, String textPass) {

    }
}
