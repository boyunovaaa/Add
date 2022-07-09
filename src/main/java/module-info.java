module com.example.add {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.add to javafx.fxml;
    exports com.example.add;
}