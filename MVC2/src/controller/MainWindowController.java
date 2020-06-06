package controller;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {
    private Main main;
    private Stage primaryStage;
    @FXML private TableView tableView;
    @FXML private TableColumn firstNameColumn;
    @FXML private TableColumn lastNameColumn;
    @FXML private TableColumn ageColumn;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField ageTextField;
    private ObservableList<Person> personList =
            FXCollections.observableArrayList();

    public void setMain(Main main, Stage primaryStage) {
        this.main = main;
        this.primaryStage = primaryStage;
        setTable();
        tableView.setItems(personList);
    }


    public void initialize() {
        firstNameColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName"));
        lastNameColumn.setCellValueFactory(
                new PropertyValueFactory < Person, String > ("lastName"));
        ageColumn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("age"));
    }

        @FXML
    public void closeStage() {
        primaryStage.close();
    }

    private void setTable() {
        personList.add(new Person("Charlie", "Brown", "10"));
        personList.add(new Person("Jan", "Kowalski", "20"));
        personList.add(new Person("Homer", "Simpson", "40"));
        personList.add(new Person("Stefan", "Nowak", "30"));
    }

    @FXML
    public void addButton() {
        System.out.println("Button pressed.");
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String age = ageTextField.getText();

        personList.add(new Person(firstName, lastName, age));

        firstNameTextField.clear();
        lastNameTextField.clear();
        ageTextField.clear();
    }
}