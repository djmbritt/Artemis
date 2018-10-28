package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.controllers.MainWindowController;
import com.sbnvw.artemis.io.IOAnimals;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class AnimalManager {

    private static AnimalManager animalManager = null;
    private static ArrayList<Animal> animals = new ArrayList<>();
    private static List<Observer> observers = new ArrayList<>();
    private static FactoryManager f = new FactoryManager();
    private static IOAnimals loader = new IOAnimals();

    private AnimalManager() {
    }

    private synchronized static void createInstance() {
        if (animalManager == null) {
            animalManager = new AnimalManager();
            AnimalManager.LoadAnimals();
        }
    }

    public static AnimalManager getInstance() {
        if (animalManager == null) {
            createInstance();
        }
        return animalManager;
    }

    public static Animal addAnimalToList(Animal a) {

        animals.add(a);

        f.alert();
        save();
        return a;
    }

    public static int removeAnimalFromList(Animal a) {

        animals.remove(a);
        f.alert();
        save();
        return animals.size() - 1;

    }

    public static int getSize() {

        return animals.size();

    }

    public static ArrayList<Animal> getAnimals() {
        return animals;
    }

    public static void clearList() {
        animals.clear();

    }

    public static void LoadAnimals() {

        AnimalManager.animals = loader.loadData();
        f.alert();

    }

    private static void save() {
        loader.saveData(AnimalManager.getAnimals());
    }

    public static void setAnimals(ArrayList<Animal> animals) {
        AnimalManager.animals = animals;
    }

}
