package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.AnimalFactory;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.ClassificationFactory;
import com.sbnvw.artemis.managers.ClassificationManager;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MakeAnimalPageController implements Initializable {

    @FXML
    private TextField phylumName;

    @FXML
    private MenuButton kingdom;

    @FXML
    private TextField classTypeName;

    @FXML
    private MenuButton phylum;

    @FXML
    private TextField orderName;

    @FXML
    private MenuButton classType;

    @FXML
    private TextField familyName;

    @FXML
    private MenuButton order;

    @FXML
    private TextField genusName;

    @FXML
    private MenuButton family;
    @FXML
    private MenuButton genus;

    @FXML
    private TextField spiciesName;

    @FXML
    private MenuButton spicies;

    @FXML
    private TextField animalName;

    @FXML
    private TextArea animalDesc;

    private List kingdoms;
    private List phylums;
    private List genuses;
    private List familys;
    private List classTypes;
    private List orders;
    private List specieses;

    private final ToggleGroup kingdomGroup = new ToggleGroup();
    private final ToggleGroup phylumGroup = new ToggleGroup();
    private final ToggleGroup genusGroup = new ToggleGroup();
    private final ToggleGroup familyGroup = new ToggleGroup();
    private final ToggleGroup classTypeGroup = new ToggleGroup();
    private final ToggleGroup orderGroup = new ToggleGroup();
    private final ToggleGroup speciesGroup = new ToggleGroup();

    @FXML
    void addAnimal(ActionEvent event) throws ClassNotFoundException {

        String name = animalName.getText();
        Object o = getObjectFromName(spicies.getText());
        String disc = animalDesc.getText();

        AnimalFactory.makeAnimal(name, (Species) o, disc);

    }

    @FXML
    void addClass(ActionEvent event) throws ClassNotFoundException {
        String n = classTypeName.getText();
        Object o = getObjectFromName(phylum.getText());
        String t = "ClassType";

        ClassificationFactory.makeClassification(n, o, t);
        initClassifications();

    }

    @FXML
    void addFamily(ActionEvent event) throws ClassNotFoundException {
        String n = familyName.getText();
        Object o = getObjectFromName(order.getText());
        String t = "Family";

        ClassificationFactory.makeClassification(n, o, t);
        initClassifications();

    }

    @FXML
    void addGenus(ActionEvent event) throws ClassNotFoundException {
        String n = genusName.getText();
        Object o = getObjectFromName(family.getText());
        String t = "Genus";

        ClassificationFactory.makeClassification(n, o, t);
        initClassifications();

    }

    @FXML
    void addOrder(ActionEvent event) throws ClassNotFoundException {
        String n = orderName.getText();
        Object o = getObjectFromName(classType.getText());
        String t = "Order";

        ClassificationFactory.makeClassification(n, o, t);
        initClassifications();

    }

    @FXML
    void addPhylum(ActionEvent event) throws ClassNotFoundException {
        String n = phylumName.getText();
        Object o = getObjectFromName(kingdom.getText());
        String t = "Phylum";

        ClassificationFactory.makeClassification(n, o, t);
        initClassifications();

    }

    @FXML
    void addSpices(ActionEvent event) throws ClassNotFoundException {
        String n = spiciesName.getText();
        Object o = getObjectFromName(genus.getText());
        String t = "Species";

        ClassificationFactory.makeClassification(n, o, t);
        initClassifications();

    }

    @FXML
    public void setSelected(ActionEvent event) {

    }

    private Object getObjectFromName(String name) throws ClassNotFoundException {
        List<Classification> c = ClassificationManager.getClassifications();
        Object o = null;
        for (int i = 0; i < c.size(); i++) {
            if (name.equals(c.get(i).getName())) {
                o = c.get(i);
            }
        }

        if (o == null) {
            throw new ClassNotFoundException(name + " does not exists");
        }

        return o;
    }

    private void Add(String name, Object o, String type) {

        try {
            ClassificationFactory.makeClassification(name, o, type);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MakeAnimalPageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MakeAnimalPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void selectedRadioItem(RadioMenuItem rmi, MenuButton mb) {
        System.out.println(rmi.toString());
        mb.setText(rmi.getText());
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initClassifications();
    }

    private void initClassifications() {
        kingdom.getItems().clear();
        phylum.getItems().clear();
        genus.getItems().clear();
        classType.getItems().clear();
        family.getItems().clear();
        spicies.getItems().clear();
        order.getItems().clear();

        kingdoms = ClassificationManager.getKingdoms();
        phylums = ClassificationManager.getPhylums();
        genuses = ClassificationManager.getGenuses();
        classTypes = ClassificationManager.getClassTypes();
        orders = ClassificationManager.getOrders();
        familys = ClassificationManager.getFamilys();
        specieses = ClassificationManager.getSpecieses();

        makeRadioItems(kingdoms, kingdomGroup, kingdom);
        makeRadioItems(phylums, phylumGroup, phylum);
        makeRadioItems(genuses, genusGroup, genus);
        makeRadioItems(classTypes, classTypeGroup, classType);
        makeRadioItems(orders, orderGroup, order);
        makeRadioItems(familys, familyGroup, family);
        makeRadioItems(specieses, speciesGroup, spicies);

    }

    private void makeRadioItems(List<Classification> l, ToggleGroup g, MenuButton mb) {

        for (int i = 0; i < l.size(); i++) {
            String n = l.get(i).getName();
            RadioMenuItem rm = new RadioMenuItem(n);
            rm.setToggleGroup(g);
            rm.setOnAction((event) -> {
                selectedRadioItem(rm, mb);
            });
            mb.getItems().add(rm);
        }

    }

    public void setButtonName(RadioMenuItem item, MenuButton mb) {

    }

}
