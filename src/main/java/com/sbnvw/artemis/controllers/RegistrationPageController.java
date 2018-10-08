package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import java.net.URL;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setContentText("Are you sure you want to reset all data fields?");
        confirmationAlert.setTitle("Confirm reset.");

        confirmationAlert.showAndWait().ifPresent((response) -> {
            if (response == ButtonType.OK) {
                FirstNameID.setText("");
                LastNameID.setText("");
//                Figure out what the proper implementation for this should be.
//                BirthDateID.setTime(DateFormat.getInstance()));
                SexID.setText("");
                AddressID.setText("");
                HouseNumberID.setText("");
                AdditionID.setText("");
                PostalCodeID.setText("");
                CountryID.setText("");
                PhoneNumberID.setText("");
                UserNameID.setText("");
                EmailID.setText("");
                RepeatEmailID.setText("");
                PasswordID.setText("");
                RepeatPasswordID.setText("");
            }
        });
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        MainApp.getMainWindowController().cancelAndReturnToMainWindow(this.getClass().getSimpleName());
    }

    @FXML
    private void saveAction(ActionEvent event) {
    }

}
