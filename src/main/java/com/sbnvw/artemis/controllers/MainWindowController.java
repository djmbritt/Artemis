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

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MainWindowController implements Initializable {

    @FXML
    private BorderPane mainWindow;
    @FXML
    private MenuItem close;
    @FXML
    private AnchorPane centerAnchor;
    @FXML
    private AnchorPane leftAnchor;
    @FXML
    private AnchorPane rightAnchor;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
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

    /**
     *
     * @param path
     */
    public void loadLeftPane(String path) {

        MainApp.loadFXMLFile(leftAnchor, path);

    }

    /**
     *
     * @param path
     */
    public void loadRightPane(String path) {

        MainApp.loadFXMLFile(rightAnchor, path);

    }

    /**
     *
     * @param path
     */
    public void loadCenterPane(String path) {

        MainApp.loadFXMLFile(centerAnchor, path);

    }

    /**
     *
     * @return
     */
    public AnchorPane getCenterAnchor() {
        return centerAnchor;
    }

    /**
     *
     * @param centerAnchor
     */
    public void setCenterAnchor(AnchorPane centerAnchor) {
        this.centerAnchor = centerAnchor;
    }

    /**
     *
     * @return
     */
    public AnchorPane getLeftAnchor() {
        return leftAnchor;
    }

    /**
     *
     * @param leftAnchor
     */
    public void setLeftAnchor(AnchorPane leftAnchor) {
        this.leftAnchor = leftAnchor;
    }

    /**
     *
     * @return
     */
    public AnchorPane getRightAnchor() {
        return rightAnchor;
    }

    /**
     *
     * @param rightAnchor
     */
    public void setRightAnchor(AnchorPane rightAnchor) {
        this.rightAnchor = rightAnchor;
    }
    
    
    
    }
