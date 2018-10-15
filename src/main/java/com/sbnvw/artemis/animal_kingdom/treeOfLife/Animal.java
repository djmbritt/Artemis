package com.sbnvw.artemis.animal_kingdom.treeOfLife;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import java.io.Serializable;

public class Animal extends AnimalClassification implements Serializable {

    private final String name;
    private final Species species;

    public Animal(String name, Species species) {
        this.name = name;
        this.species = species;
    }

}
