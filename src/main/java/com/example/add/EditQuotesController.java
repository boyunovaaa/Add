package com.example.add;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditQuotesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField;

    @FXML
    private Button editQuotesButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField dateField;

    @FXML
    private TextField subjectField;

    @FXML
    private TextField teacherField;

    @FXML
    private TextField numberField;

    @FXML
    void initialize() {
        editQuotesButton.setOnAction(actionEvent -> {
            if(UserQuotes.user.getStatus() == 3){
                editQuotes();
            }
            if(UserQuotes.user.getStatus() == 2){
                editQuotes();
            }
            editQuotes();
            editQuotesButton.getScene().getWindow().hide();
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

        backButton.setOnAction(actionEvent -> {
            backButton.getScene().getWindow().hide();
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

    public void editQuotes(){
        Connections connect = new Connections();

        String id = numberField.getText();
        String text = textField.getText();
        String date = dateField.getText();
        String subject = subjectField.getText();
        String teacher = teacherField.getText();
        Integer user_id = UserQuotes.user.getId();

        //connect.UserStatus();
        Quotes quotes = new Quotes(id, text, date, subject, user_id, teacher);

        if(UserQuotes.user.getStatus() == 3) {
            connect.editQuotes3(quotes);
        }
        else if(UserQuotes.user.getStatus() == 2) {
            connect.editQuotes2(quotes);
        }
        else if(UserQuotes.user.getStatus() == 1) {
            connect.editQuotes1(quotes);
        }
    }
}
