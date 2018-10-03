package com.sbnvw.artemis.animal_kingdom.treeOfLife;

import com.sbnvw.artemis.animal_kingdom.traits.diet.Diet;
import com.sbnvw.artemis.animal_kingdom.traits.fur.Fur;

public abstract class Animal {

    private static int animals;
    private final int animalID;
    private final String name;
    private final boolean hasHeartBeat = true;
    private Diet diet;
    private Fur fur;

    /**
     *
     * @param name
     */
    public Animal(String name) {
        this.name = name;
        this.animalID = animals;
        animals++;

    }

    /**
     *
     * @return 
     */
    public int getAnimalID() {
        return animalID;
    }

    /**
     *
     * @return the amount of animals that exisit in the progam.
     */
    public static int getAnimals() {
        return animals;
    }

    /**
     *
     * @return the name of the animal.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return if the animal has a heartbeat.
     */
    public boolean getHasHeartBeat() {
        return hasHeartBeat;
    }

    /**
     *
     * @param diet
     */
    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    /**
     *
     * @return the type of diet that the animal eats.
     */
    public Diet getDiet() {
        return diet;
    }

    /**
     * sets the fur type of the animal.
     *
     * @param fur sets the type of fur.
     */
    public void setFur(Fur fur) {
        this.fur = fur;
    }

    /**
     * Get the fur type of the animal.
     *
     * @return fur
     */
    public Fur getFur() {
        return fur;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

}
