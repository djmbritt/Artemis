package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.account.AccountFactory;
import com.sbnvw.artemis.account.UserInformation;
import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author djmbritt
 */
public class RegistrationPageController implements Initializable {

    @FXML
    private Button cancelBtnID;

    @FXML
    private TextField FirstNameID;

    @FXML
    private TextField LastNameID;

    @FXML
    private TextField SexID;

    @FXML
    private TextField AddressID;

    @FXML
    private TextField HouseNumberID;

    @FXML
    private TextField AdditionID;

    @FXML
    private TextField PostalCodeID;

    @FXML
    private TextField CountryID;

    @FXML
    private TextField PhoneNumberID;

    @FXML
    private TextField UserNameID;

    @FXML
    private TextField EmailID;

    @FXML
    private TextField RepeatEmailID;

    @FXML
    private PasswordField PasswordID;

    @FXML
    private PasswordField RepeatPasswordID;

    @FXML
    private Button resetBtnID;

    @FXML
    private Button SaveBtnID;

    @FXML
    private VBox valueFields;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void resetAction(ActionEvent event) {
        System.out.println("RegistrationPageController.java::ResetAction");

        new Alert(Alert.AlertType.CONFIRMATION, "Reset all fields?")
                .showAndWait()
                .filter(response -> response == ButtonType.OK)
                .ifPresent(response -> {
                    valueFields
                            .getChildren()
                            .filtered(node -> node instanceof TextField)
                            .forEach(node -> {
                                System.out.println("NodeID: " + node.getId());
                                ((TextField) node).setText("");
                            });
                });
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        MainApp.getMainWindowController().cancelAndReturnToMainWindow(this.getClass().getSimpleName());
    }

    @FXML
    private void saveAction(ActionEvent event) {
        //Check to see if all fields are filled in.
        Boolean allFieldsFilledIn = valueFields
                .getChildren()
                .filtered(node -> node instanceof TextField)
                .filtered(node -> ((TextField) node).getText().isEmpty())
                .isEmpty();

        // Check to see if email already exists
        Boolean emailExistence = new IOContext(new IOUsers()).load().stream().anyMatch((user) -> {
            return EmailID.getText().equals(((UserInformation) user).getEmail());
        });

        // if passwords do not match each other.
        if (!PasswordID.getText().equals(RepeatPasswordID.getText())) {
            new Alert(Alert.AlertType.ERROR, "Repeat password does not match.").showAndWait();
        }

        // if emails do not match eachother
        if (!EmailID.getText().equals(RepeatEmailID.getText())) {
            new Alert(Alert.AlertType.ERROR, "Repeat email does not match.").showAndWait();
        }

        // if not all fields are filled in
        if (!allFieldsFilledIn) {
            new Alert(Alert.AlertType.ERROR, "Not all fields are filled in.").showAndWait();
        }

        // if email already exisist.
        if (emailExistence) {
            new Alert(Alert.AlertType.ERROR, "Email already take, try another one.").showAndWait();
        } else {

            UserInformation newUser = AccountFactory.createAccount(
                    "user",
                    PasswordID.getText(),
                    UserNameID.getText(),
                    FirstNameID.getText(),
                    LastNameID.getText(),
                    null,
                    SexID.getText(),
                    EmailID.getText(),
                    PhoneNumberID.getText(),
                    AddressID.getText(),
                    HouseNumberID.getText(),
                    AdditionID.getText(),
                    PostalCodeID.getText(),
                    CountryID.getText(),
                    null
            );

//            System.out.println("accounttype: " + newUser.getAccountType());
            System.out.println("username: " + newUser.getUserName());
            System.out.println("firstName: " + newUser.getFirstName());
            
            //This could be implemted in a better way. But it works for now.
            if (newUser.getFirstName().equals(FirstNameID.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, newUser.getFirstName() + " succesfully registered.").showAndWait();
                MainApp.loadMainWindow();
            } else {
                new Alert(Alert.AlertType.ERROR, "Something went wrong, please contact sysAdmin.").showAndWait();
            }

        }

    }

}
