package com.example.add;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SawQuotesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Quotes> tableQuotes2;

    @FXML
    private TableColumn<Quotes, Integer> id;

    @FXML
    private TableColumn<Quotes, String> Text;

    @FXML
    private TableColumn<Quotes, String> Date;

    @FXML
    private TableColumn<Quotes, String> Subject;

    @FXML
    private TableColumn<Quotes, Integer> UserId;

    @FXML
    private TableColumn<Quotes, String> Teacher;

    @FXML
    private Button exitButton;

    ObservableList<Quotes> list2 = FXCollections.observableArrayList();

    @FXML
    void initialize() throws ClassNotFoundException, SQLException {
        list2.addAll(Connections.getQuotes());

        id.setCellValueFactory(new PropertyValueFactory<Quotes, Integer>("id"));
        Text.setCellValueFactory(new PropertyValueFactory<Quotes, String>("Text"));
        Date.setCellValueFactory(new PropertyValueFactory<Quotes, String>("Date"));
        Subject.setCellValueFactory(new PropertyValueFactory<Quotes, String>("Subject"));
        UserId.setCellValueFactory(new PropertyValueFactory<Quotes, Integer>("UserId"));
        Teacher.setCellValueFactory(new PropertyValueFactory<Quotes, String>("Teacher"));

        tableQuotes2.setItems(list2);

        exitButton.setOnAction(actionEvent -> {
            exitButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));
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
}
