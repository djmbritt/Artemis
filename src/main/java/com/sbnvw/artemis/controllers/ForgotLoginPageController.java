/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author djmbritt
 */
public class ForgotLoginPageController implements Initializable {

    @FXML
    private TextField FirstNameID;
    @FXML
    private Button cancelBtnID;
    @FXML
    private Button SendBtnID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void cancelAction(ActionEvent event) {
        MainApp.getMainWindowController().cancelAndReturnToMainWindow(this.getClass().getSimpleName());
    }

    @FXML
    private void SendAction(ActionEvent event) {
    }
    
}
