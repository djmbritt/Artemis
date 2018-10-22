package com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.ClassType;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Family;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Genus;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Kingdom;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Order;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Phylum;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import com.sbnvw.artemis.managers.ClassificationManager;
import com.sbnvw.artemis.managers.FactoryManager;
import com.sbnvw.artemis.managers.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel van Wilgenburg
 */
public final class ClassificationFactory implements Factory {

    private static List<Classification> classList = ClassificationManager.getClassifications();

    public ClassificationFactory() {
        FactoryManager f = new FactoryManager();
        f.attach(this);
    }

    public static Classification makeClassification(String name, Object parant, String type) throws ClassNotFoundException, IllegalArgumentException {

        switch (type) {
            case "Kingdom":
                if (!alreadyExists(name, Kingdom.class)) {
                    return ClassificationManager.addClasification(new Kingdom(name));
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }
            case "Phylum":
                if (!alreadyExists(name, Phylum.class)) {
                    return ClassificationManager.addClasification(new Phylum(name, (Kingdom) parant));

                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "ClassType":
                if (!alreadyExists(name, ClassType.class)) {
                    return ClassificationManager.addClasification(new ClassType(name, (Phylum) parant));

                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Order":
                if (!alreadyExists(name, Order.class)) {
                    return ClassificationManager.addClasification(new Order(name, (ClassType) parant));

                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Family":
                if (!alreadyExists(name, Family.class)) {
                    return ClassificationManager.addClasification(new Family(name, (Order) parant));

                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Genus":
                if (!alreadyExists(name, Genus.class)) {
                    return ClassificationManager.addClasification(new Genus(name, (Family) parant));

                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Species":
                if (!alreadyExists(name, Species.class)) {
                    return ClassificationManager.addClasification(new Species(name, (Genus) parant));

                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            default:
                throw new ClassNotFoundException("Class : " + type + " does not exists");
        }
        
        

    }

    public static boolean alreadyExists(String name, Object c) {
        for (int i = 0; i < classList.size(); i++) {
            if (classList.get(i).getClass().equals(c)) {
                if (classList.get(i).getName().equalsIgnoreCase(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void update() {
        classList = ClassificationManager.getClassifications();
    }

}
