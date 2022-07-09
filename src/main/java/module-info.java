module com.example.add {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.add to javafx.fxml;
    exports com.example.add;
}