package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.ClassType;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Family;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Genus;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Kingdom;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Order;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Phylum;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.RadioMenuItem;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class ClassificationManager {

    private static List<Classification> classifications = new ArrayList<>();
    private static List<Observer> observers = new ArrayList<>();

    private static final List<Kingdom> kingdoms = new ArrayList<>();
    private static final List<Phylum> phylums = new ArrayList<>();
    private static final List<Genus> genuses = new ArrayList<>();
    private static final List<Family> familys = new ArrayList<>();
    private static final List<ClassType> classTypes = new ArrayList<>();
    private static final List<Order> orders = new ArrayList<>();
    private static final List<Species> specieses = new ArrayList<>();

    public static Classification addClasification(Classification classification) {

        classifications.add(classification);

        Object o = classification;
        if (o instanceof Kingdom) {
            kingdoms.add((Kingdom) o);

        } else if (o instanceof Phylum) {
            phylums.add((Phylum) o);

        } else if (o instanceof Family) {
            familys.add((Family) o);

        } else if (o instanceof Genus) {
            genuses.add((Genus) o);

        } else if (o instanceof Order) {
            orders.add((Order) o);

        } else if (o instanceof ClassType) {
            classTypes.add((ClassType) o);

        } else if (o instanceof Species) {
            specieses.add((Species) o);

        }

        FactoryManager f = new FactoryManager();
        f.alert();

        return classification;

    }

    public static Classification getClassificationByName(String name) throws ClassNotFoundException {
        Classification c = null;

        for (int i = 0; i < classifications.size(); i++) {
            if (classifications.get(i).getName().equalsIgnoreCase(name)) {
                c = classifications.get(i);
                break;
            }
        }

        if (c == null) {
            throw new ClassNotFoundException(name + " does not exists");
        }

        return c;
    }

    public static List<Classification> getClassifications() {
        return classifications;
    }

    public static List<Observer> getObservers() {
        return observers;
    }

    public static List<Kingdom> getKingdoms() {
        return kingdoms;
    }

    public static List<Phylum> getPhylums() {
        return phylums;
    }

    public static List<Genus> getGenuses() {
        return genuses;
    }

    public static List<Family> getFamilys() {
        return familys;
    }

    public static List<ClassType> getClassTypes() {
        return classTypes;
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static List<Species> getSpecieses() {
        return specieses;
    }

}
