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

public class ChangePassController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button changePasswordButton;

    @FXML
    private PasswordField newPassField;

    @FXML
    void initialize() {
        changePasswordButton.setOnAction(actionEvent -> {
            changeUser();
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
            stage.showAndWait();
        });
    }

    private void changeUser() {
        Connections connect = new Connections();

        String login = loginField.getText();
        String password = passwordField.getText();
        String newPass = newPassField.getText();

        User user = new User(login, password, newPass);

        connect.newUser(user);
    }
}
