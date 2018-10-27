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

    public List<Trait> getTraits() {
        List<Trait> traits = getSpecies().getTraits();

        return traits;

    }

    public String getDesc() {
        return this.desc;
    }

    @Override
    public String toString() {
        String traits = "Traits";
        List<Trait> tr = getTraits();
        for (int i = 0; i < tr.size(); i++) {
            traits += " : "+tr.get(i).getName();
            
        }
        
        
       return getSpecies().getName() + " : " + getName() + " : " + traits;
    }
    
    

}
