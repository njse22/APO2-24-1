package org.example.demofx2.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FormAddPersonController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ageTextFiled;

    @FXML
    private Button addPersonButton;

    @FXML
    public void onAddPerson(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        int age = Integer.parseInt(ageTextFiled.getText());

        // llamar controlador de persona, para crear el objeto
        PersonController.getInstance().addPerson(name, age);
    }
}
