package com.sbnvw.artemis.animal_kingdom.treeOfLife;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.AnimalFactory;
import java.io.Serializable;
import java.util.List;

public class Animal implements Serializable {

    private final String name;
    private final Species species;

    public Animal(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public List getTraits() {
        return getSpecies().getTraits();

    }

}
