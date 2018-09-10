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
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Zilverdrake
 */
public class MainWindowController implements Initializable {
    
    @FXML
    private BorderPane mainWindow;
    @FXML
    private MenuItem close;
    @FXML
    private AnchorPane centerAnchor;
    @FXML
    private VBox leftAnchor;
    @FXML
    private AnchorPane rightAnchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.loadFXMLFile(centerAnchor, "/fxml/LoginPage.fxml");
        centerAnchor.autosize();
        MainApp.setMainWindowController(this);
        
    }
    
    @FXML
    void closeApp(ActionEvent event) {
        
        System.exit(0);
        
    }
    
    public void loadLeftPane(String path) {
        
        MainApp.loadFXMLFile(leftAnchor, path);
        
    }
    
}
