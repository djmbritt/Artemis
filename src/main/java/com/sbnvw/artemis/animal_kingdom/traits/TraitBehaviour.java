package com.sbnvw.artemis.animal_kingdom.traits;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class TraitBehaviour extends Trait implements Serializable{

    private String behaviour;
    private TraitGroup traitGroup;

    public TraitBehaviour(String behaviour, TraitGroup traitGroup) {
        this.behaviour = behaviour;
        this.traitGroup = traitGroup;
    }

    public String getBehaviour() {
        return behaviour;
    }

    public TraitGroup getTraitGroup() {
        return traitGroup;
    }

    @Override
    public String getName() {
        return this.behaviour;
    }
    

}
