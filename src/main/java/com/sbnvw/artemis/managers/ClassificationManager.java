package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class ClassificationManager implements Observable{

    private static List<Classification> classifications = new ArrayList<>();
    private static List<Observer> observers = new ArrayList<>();

    public static void addClasification(Classification classification) {

        classifications.add(classification);
        

    }

    public static List<Classification> getClassifications() {
        return classifications;
    }

    @Override
    public void attach(Object object) {
        observers.add((Observer) object);
    }

    @Override
    public void detach(Object object) {
        observers.remove(object);
    }

    @Override
    public void alert() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update();
        }
    }

}
