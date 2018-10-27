package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.managers.AnimalManager;
import com.sbnvw.artemis.managers.FactoryManager;
import com.sbnvw.artemis.managers.Observer;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MainSearchWindowController implements Initializable, Observer {

    @FXML
    private ListView<Animal> animals;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FactoryManager m = new FactoryManager();
        m.attach(this);
        updateList();

    }

    public void updateList() {
        animals.getItems().clear();
        List<Animal> a = AnimalManager.getAnimals();
        for (int i = 0; i < a.size(); i++) {
            animals.getItems().add(a.get(i));
        }
    }

    @Override
    public void update() {
        updateList();
    }

}
