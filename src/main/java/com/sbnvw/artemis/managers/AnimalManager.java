package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import java.util.ArrayList;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class AnimalManager {

    private static AnimalManager animalManager = null;
    private static ArrayList<Animal> animals;

    private AnimalManager() {
        animals = new ArrayList<>();
    }

    private synchronized static void createInstance() {
        if (animalManager == null) {
            animalManager = new AnimalManager();
        }
    }

    public static AnimalManager getInstance() {
        if (animalManager == null) {
            createInstance();
        }
        return animalManager;
    }

    public static int addAnimalToList(Animal a) {

        animals.add(a);
        return animals.size() - 1;
    }

    public static int removeAnimalFromList(Animal a) {

        animals.remove(a);
        return animals.size() - 1;

    }

    public static int getSize() {

        return animals.size();

    }

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }

}
