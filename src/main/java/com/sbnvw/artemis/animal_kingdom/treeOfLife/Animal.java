package com.sbnvw.artemis.animal_kingdom.treeOfLife;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.AnimalFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.text.Text;

public class Animal implements Serializable {

    private final String name;
    private final Species species;
    private String desc;

    public Animal(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    public Animal(String name, Species species, String desc) {
        this.name = name;
        this.species = species;
        this.desc = desc;

    }

    public String getName() {
        return name;
    }

    public Species getSpecies() {
        return species;
    }

    public List getTraits() {
        List<Trait> traits = new ArrayList<>();

        return traits;

    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public String toString() {
       return getSpecies().getName() + " : " + getName();
    }
    
    

}
