package com.example.f23comp1011tasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersController implements Initializable {

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Label respnoseMessageLabel;

    @FXML
    private TextField userNameTextField;

    @FXML
    void saveUser(ActionEvent event) {
        String email = emailTextField.getText();
        String userName = userNameTextField.getText();
        String phone = phoneTextField.getText();

        try {
            User newUser = new User(email, userName, phone);
            respnoseMessageLabel.setText(DBUtility.addUser(newUser));
        } catch (IllegalArgumentException e) {
            respnoseMessageLabel.setText(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        respnoseMessageLabel.setText("");
        emailTextField.setText("");
        userNameTextField.setText("");
        phoneTextField.setText("");
    }
}
