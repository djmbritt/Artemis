package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.managers.AnimalManager;
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
    
    @FXML
    public void makeNewQuiz(ActionEvent event) throws IOException {
        MainApp.loadFXMLFileInNewWindow("/fxml/makeNewQuiz.fxml", "Quiz Creator");
    }

    @FXML
    public void remove(ActionEvent event) throws ClassNotFoundException {
        Animal A = MainSearchWindowController.getSelf().getSelectedItem();
        AnimalManager.removeAnimalFromList(A);
        
        

    }

}
