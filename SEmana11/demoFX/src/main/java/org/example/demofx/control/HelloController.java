package org.example.demofx.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.UUID;

public class HelloController {
    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label ageLabel;

    @FXML
    private TextField ageTextField;

    @FXML
    private Label listPersonLabel;


    private PersonController personController;

    public HelloController() {
        personController = new PersonController();
    }

    @FXML
    protected void onAddPerson() {
        String name = nameTextField.getText();
        int age = Integer.parseInt(ageTextField.getText());
        String id = UUID.randomUUID().toString();

        personController.addPerson(name, age, id );

        listPersonLabel.setText(personController.printPeople());

    }
}