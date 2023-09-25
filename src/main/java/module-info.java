module com.example.f23comp1011tasks {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.f23comp1011tasks to javafx.fxml;
    exports com.example.f23comp1011tasks;
}