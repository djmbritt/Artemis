package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class AdminMenuController implements Initializable {

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
    public void makeNewPage(ActionEvent event) throws IOException {
        MainApp.loadFXMLFileInNewWindow("/fxml/MakeAnimalPage.fxml", "Animal Creator");

    }

    @FXML
    public void makeNewTrait(ActionEvent event) throws IOException {
        MainApp.loadFXMLFileInNewWindow("/fxml/makeNewTrait.fxml", "Trait Creator");

    }

}
