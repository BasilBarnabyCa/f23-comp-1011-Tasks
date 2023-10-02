package com.example.f23comp1011tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TaskController {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private Spinner<?> estimatedLengthSpinner;

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<?> userComboBox;

    @FXML
    void saveTask(ActionEvent event) {

    }

}
