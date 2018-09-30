package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.canidae.dogs.Dog;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.cats.smallCats.Cat;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MainSearchWindowController implements Initializable {

    @FXML
    private ListView<?> animalList;
    @FXML
    private AnchorPane prefWindow;

    ArrayList<Animal> animals = new ArrayList<>();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.setMainSearchWindowController(this);
        Cat a = new Cat("Korthaar");
        Dog b = new Dog("Labarador");
        
        animals.add(a);
        animals.add(b);
        
        setAnimalsList(animals);

    }
/**
 * 
 * @param list 
 */
    public void setAnimalsList(ArrayList list) {
        animalList.getItems().clear();
        animalList.getItems().setAll(list);

    }
    
    @FXML
    public void getSelectedItem(MouseEvent event ){
        MainApp.getMainWindowController().loadRightPane("/fxml/PreviewWindow.fxml");
        
    }

}
