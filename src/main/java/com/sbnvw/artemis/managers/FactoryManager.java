package com.sbnvw.artemis.managers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class FactoryManager implements Observable {

    private static List<Observer> observers = new ArrayList<>();

    public FactoryManager() {
        
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
