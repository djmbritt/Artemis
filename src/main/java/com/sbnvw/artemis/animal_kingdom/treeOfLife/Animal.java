package com.sbnvw.artemis.animal_kingdom.treeOfLife;

public abstract class Animal {

    private static int animals;
    private final int animalID;
    private final String name;
    private final boolean hasHeartBeat = true;

    public Animal(String name) {
        this.name = name;
        this.animalID = animals;
        animals++;

    }

    public int getAnimalID() {
        return animalID;
    }

    public static int getAnimals() {
        return animals;
    }

    public String getName() {
        return name;
    }

    public boolean getHasHeartBeat() {
        return hasHeartBeat;
    }

    @Override
    public String toString() {
        return this.getName();
    }
    
    
}
