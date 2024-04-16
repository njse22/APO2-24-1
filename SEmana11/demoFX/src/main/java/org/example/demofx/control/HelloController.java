package org.example.demofx.control;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class HelloController {
    @FXML
    private Label listPersonLabel;

    @FXML
    private TextArea inputInformationTextArea;

    private PersonController personController;

    public HelloController() {
        personController = new PersonController();
    }

    @FXML
    protected void onAddPerson() {
        String inputInformation = inputInformationTextArea.getText();

        String[] information = inputInformation.split(",");
        personController.addPerson(
                information[0],
                Integer.parseInt(information[1]),
                information[2]);

        listPersonLabel.setText(personController.printPeople());
    }
}