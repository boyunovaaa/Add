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

public class AddQuotesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField;

    @FXML
    private TextField dateField;

    @FXML
    private Button addQuotesButton;

    @FXML
    private TextField subjectField;

    @FXML
    private Button backButton;

    @FXML
    private TextField teacherField;

    @FXML
    void initialize() {
        addQuotesButton.setOnAction(actionEvent -> {
            //newQuotes();
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

    /*private void newQuotes() {
        Connections connect = new Connections();
        User user = new User();

        String Text = textField.getText();
        String Date = dateField.getText();
        String Subject = subjectField.getText();
        String Teacher = teacherField.getText();

        Quotes quotes = new Quotes(Text, Date, Subject, Teacher, user.getId());

        connect.newQuotes(quotes);
    }

     */


}
