package com.example.f23comp1011tasks;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TaskController implements Initializable {

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private Spinner<Integer> durationSpinner;

    @FXML
    private Label msgLabel;

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<User> userComboBox;

    @FXML
    void saveTask(ActionEvent event) {
        // TODO: ADD SAVE LOGIC
        if(areFieldsUpdated())
        {
            // Create task object
            String title = titleTextField.getText();
            String description = descriptionTextArea.getText();
            LocalDate dueDate = dueDatePicker.getValue();
            int duration = durationSpinner.getValue();
            User user = userComboBox.getValue();

            try {
                Task task = new Task(title, description, dueDate, duration, user);

                // Add task to the database
                msgLabel.setText(DBUtility.addTask(task));
            }
            catch(IllegalArgumentException e) {
                msgLabel.setText(e.getMessage());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean areFieldsUpdated()
    {
        return !titleTextField.getText().isEmpty() &&
                !descriptionTextArea.getText().isEmpty() &&
                dueDatePicker.getValue() != null &&
                userComboBox.getValue() != null;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Configure date picker to automatically set as the due date
        dueDatePicker.setValue(LocalDate.now().plusDays(1));

        // Configure the userComboBox to hold users from the DB
        userComboBox.getItems().addAll(DBUtility.getUsers());

        // Configure the estimated length spinner
        // 1 - 120 minutes

        SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 120, 60);

        durationSpinner.setValueFactory(spinnerValueFactory);
        durationSpinner.setEditable(true);
        TextField spinnerTextField = durationSpinner.getEditor();
        spinnerTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                // Check for empty string first
                if (newValue.trim().isEmpty()) {
//                    spinnerValueFactory.setValue(1);
                    spinnerTextField.setText("1");
                    return;
                }
               spinnerValueFactory.setValue(Integer.parseInt(newValue));
            } catch (NumberFormatException e) {
                spinnerTextField.setText(oldValue);
            }
        });

    }
}
