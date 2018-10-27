package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.managers.AnimalManager;
import com.sbnvw.artemis.managers.FactoryManager;
import com.sbnvw.artemis.managers.Observer;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MainSearchWindowController implements Initializable, Observer {

    @FXML
    private ListView<Animal> animals;
    @FXML
    private TextField searchBar;
    @FXML
    private AnchorPane prefwindow;

    private Animal selectedAnimal;
    private static MainSearchWindowController self;
    private SearchController searchController;

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
        self = this;
        try {
            searchController = new SearchController();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainSearchWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            search();
        });
        
        

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

    public void search() {

        if (!searchBar.getText().isEmpty()) {
            animals.getItems().clear();
            List<Animal> a = searchController.searchForAnimals(searchBar.getText());
            for (int i = 0; i < a.size(); i++) {
                animals.getItems().add(a.get(i));
            }
        } else {
            update();
        }

    }

    public TextField getSearchBar() {
        return searchBar;
    }

    public static MainSearchWindowController getSelf() throws ClassNotFoundException {
        if (self == null) {
            throw new ClassNotFoundException("Class not found");
        } else {

            return self;

        }

    }

    @FXML
    public void getSelectedAnimal() {
        selectedAnimal = animals.getSelectionModel().getSelectedItem();
        System.out.println(selectedAnimal.toString());
    }

    public Animal getSelectedItem() throws IllegalArgumentException {

        if (selectedAnimal != null) {
            return selectedAnimal;
        } else {

            throw new IllegalArgumentException("No animal selected");

        }

    }

}
