package com.example.add;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage.setTitle("Authorization");
        stage.setScene(new Scene(root, 700, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}