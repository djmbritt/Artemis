package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.Factory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MakeNewTraitController implements Initializable, Factory {

    @FXML
    private TextField groupName;

    @FXML
    private TextField behaveiorName;

    @FXML
    private MenuButton behaviors;

    @FXML
    private MenuButton Classifications;
    
    private List<Classification> classifications = new ArrayList<>();

    @FXML
    void addBehaviour(ActionEvent event) {

    }

    @FXML
    void addGroup(ActionEvent event) {

    }

    @FXML
    void addToClassification(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void update() {
        
    }
    
    public void init(){
        
        //TODO load classifications to the buttons
        
    }

}
