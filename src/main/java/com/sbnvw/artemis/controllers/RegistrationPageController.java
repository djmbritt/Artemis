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

    private TextField LastNameID;


    private TextField SexID;

    private TextField AddressID;

    private TextField HouseNumberID;

    private TextField AdditionID;

    private TextField PostalCodeID;

    private TextField CountryID;

    private TextField PhoneNumberID;

    private TextField UserNameID;

    private TextField EmailID;

    private TextField RepeatEmailID;

    private PasswordField PasswordID;

    private PasswordField RepeatPasswordID;
    @FXML
    private Button SendBtnID;

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
                System.out.println("RegistrationPageController.java::CancelAction");

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setContentText("Are you sure you want to cancel?");
        confirmationAlert.setTitle("Confirm cancelation.");

        confirmationAlert.showAndWait().ifPresent((response) -> {
            if (response == ButtonType.OK) {
                MainApp.getMainWindowController().loadCenterPane("/fxml/LoginPage.fxml");
            }
        });
    }

    @FXML
    private void SendAction(ActionEvent event) {
    }

}
