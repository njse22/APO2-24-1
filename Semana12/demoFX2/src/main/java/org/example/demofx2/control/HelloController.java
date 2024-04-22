package org.example.demofx2.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.demofx2.HelloApplication;
import org.example.demofx2.model.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Person> tableViewPerson;

    @FXML
    private TableColumn<Person, String> nameTC;

    @FXML
    private TableColumn<Person, Integer> ageTC;

    @FXML
    public void onAddPerson(ActionEvent actionEvent) {
        HelloApplication.openWindow("form-add-person.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageTC.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableViewPerson.setItems(PersonController.getInstance().getPeople());
    }
}