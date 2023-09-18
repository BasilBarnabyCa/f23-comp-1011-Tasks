module com.example.f23comp1011tasks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f23comp1011tasks to javafx.fxml;
    exports com.example.f23comp1011tasks;
}