/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author djmbritt
 */
public class AdminRegistrationPageController implements Initializable {

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
    private Button cancelBtnID;
    @FXML
    private Button SaveBtnID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void resetAction(ActionEvent event) {
    }

    @FXML
    private void cancelAction(ActionEvent event) {
    }

    @FXML
    private void saveAction(ActionEvent event) {
    }
    
}
