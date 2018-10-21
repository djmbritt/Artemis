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
public final class ClassificationFactory implements Factory{

    private static List<Classification> classList = ClassificationManager.getClassifications();

    public ClassificationFactory() {
        FactoryManager f = new FactoryManager();
        f.attach(this);
    }

    public static void makeClassification(String name, Object parant, String type) throws ClassNotFoundException, IllegalArgumentException {

        switch (type) {
            case "Kingdom":
                if (!alreadyExists(name, Kingdom.class)) {
                    ClassificationManager.addClasification(new Kingdom(name));
                    break;
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }
            case "Phylum":
                if (!alreadyExists(name, Phylum.class)) {
                    ClassificationManager.addClasification(new Phylum(name, (Kingdom) parant));
                    break;
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Class":
                if (!alreadyExists(name, ClassType.class)) {
                    ClassificationManager.addClasification(new ClassType(name, (Phylum) parant));
                    break;
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Order":
                if (!alreadyExists(name, Order.class)) {
                    ClassificationManager.addClasification(new Order(name, (ClassType) parant));
                    break;
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Family":
                if (!alreadyExists(name, Family.class)) {
                    ClassificationManager.addClasification(new Order(name, (ClassType) parant));
                    break;
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Genus":
                if (!alreadyExists(name, Genus.class)) {
                    ClassificationManager.addClasification(new Genus(name, (Family) parant));
                    break;
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            case "Species":
                if (!alreadyExists(name, Species.class)) {
                    ClassificationManager.addClasification(new Species(name, (Genus) parant));
                    break;
                } else {
                    //TODO make this into a real error, this is a placeholder
                    throw new IllegalArgumentException("Name already exists");
                }

            default:
                throw new ClassNotFoundException("Class:" + name + " does not exisit");
        }

    }

    public static boolean alreadyExists(String name, Class c) {
        try {
            Object object = c.newInstance();

            for (int i = 0; i < classList.size(); i++) {
                if (classList.get(i).getClass().equals(object)) {
                    if (classList.get(i).getName().equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            }

        } catch (InstantiationException ex) {
            Logger.getLogger(ClassificationFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClassificationFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void update() {
        classList = ClassificationManager.getClassifications();
    }

}
