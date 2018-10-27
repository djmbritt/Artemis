package com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import com.sbnvw.artemis.managers.AnimalManager;
import com.sbnvw.artemis.managers.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class AnimalFactory implements Factory {

    private static AnimalFactory animalFactory = null;
    private static final List<Animal> ANIMALS = AnimalManager.getAnimals();

    private synchronized static void createInstance() {
        if (animalFactory == null) {
            animalFactory = new AnimalFactory();
        }
    }

    public static AnimalFactory getInstance() {
        if (animalFactory == null) {
            createInstance();
        }
        return animalFactory;
    }

    public static Animal makeAnimal(String name, Species species, String desc) {
        return AnimalManager.addAnimalToList(new Animal(name, species, desc));
    }

    public static Animal makeAnimal(String name, Species species) {
        return AnimalManager.addAnimalToList(new Animal(name, species));
    }

    @Override
    public void update() {
        AnimalManager.getAnimals();
    }

}
