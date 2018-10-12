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

/**
 * FXML Controller class
 *
 * @author djmbritt
 */
public class SystemAdminMenuController implements Initializable {

    @FXML
    private Button createAdminID;
    @FXML
    private Button viewUserID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnCreateAdmin(ActionEvent event) {
                MainApp.getMainWindowController().loadCenterPane("/fxml/Registration_Page.fxml");
    }

    @FXML
    private void btnViewUser(ActionEvent event) {
    }
    
}
