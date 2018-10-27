package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.animal_kingdom.traits.TraitBehaviour;
import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.Factory;
import com.sbnvw.artemis.managers.ClassificationManager;
import com.sbnvw.artemis.managers.FactoryManager;
import com.sbnvw.artemis.managers.TraitsManager;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
    @FXML
    private MenuButton traitGroupAdd;

    private List<Classification> classifications;
    private List<TraitGroup> traitGroups;
    private ToggleGroup classToggleGroup = new ToggleGroup();
    private ToggleGroup TraitsgToggleGroup = new ToggleGroup();
    private ToggleGroup TraitAddToggleGroup = new ToggleGroup();

    private FactoryManager f = new FactoryManager();

    @FXML
    void addBehaviour(ActionEvent event) throws ClassNotFoundException {

        String name = behaveiorName.getText();

        TraitGroup traitGroup = (TraitGroup) TraitsManager.getTraitGroupFromName(traitGroupAdd.getText());

        traitGroup.addTraitBehaviour(new TraitBehaviour(name, traitGroup));

        f.alert();

    }

    @FXML
    void addGroup(ActionEvent event) {

        f.alert();

    }

    @FXML
    void addToClassification(ActionEvent event) {

        try {
            String bh = behaviors.getText();
            String cl = Classifications.getText();

            TraitBehaviour traitBehaviour = TraitsManager.getTraitBehaviourByName(bh);
            TraitGroup group = traitBehaviour.getTraitGroup();

            ClassificationManager.getClassificationByName(cl).addTrait(new TraitBehaviour(bh, group));
            f.alert();
            System.out.println(bh);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeNewTraitController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
        FactoryManager f = new FactoryManager();
        f.attach(this);
    }

    @Override
    public void update() {

        init();

    }

    public void init() {

        classifications = ClassificationManager.getClassifications();
        traitGroups = TraitsManager.getTRAIT_GROUPS();
        traitGroupAdd.getItems().clear();

        behaviors.getItems().clear();
        Classifications.getItems().clear();

        for (int i = 0; i < traitGroups.size(); i++) {
            Menu group = new Menu();
            RadioMenuItem tri = new RadioMenuItem(traitGroups.get(i).getName());
            tri.setOnAction((event) -> {
                selectedRadioItem(tri, traitGroupAdd);
            });
            tri.setToggleGroup(TraitAddToggleGroup);
            traitGroupAdd.getItems().add(tri);
            group.setText(traitGroups.get(i).getName());
            List<TraitBehaviour> tbs = traitGroups.get(i).getTraitBehaviours();
            for (int j = 0; j < tbs.size(); j++) {
                RadioMenuItem rmi = new RadioMenuItem(tbs.get(j).getBehaviour());
                rmi.setToggleGroup(TraitsgToggleGroup);
                rmi.setOnAction((event) -> {
                    selectedRadioItem(rmi, behaviors);
                });
                group.getItems().add(rmi);
            }

            behaviors.getItems().add(group);
        }

        for (int i = 0; i < classifications.size(); i++) {
            RadioMenuItem rmi = new RadioMenuItem(classifications.get(i).getName());
            rmi.setToggleGroup(classToggleGroup);
            rmi.setOnAction((event) -> {
                selectedRadioItem(rmi, Classifications);
            });
            Classifications.getItems().add(rmi);
        }

    }

    public void selectedRadioItem(RadioMenuItem rmi, MenuButton mb) {
        System.out.println(rmi.toString());
        mb.setText(rmi.getText());
    }

}
