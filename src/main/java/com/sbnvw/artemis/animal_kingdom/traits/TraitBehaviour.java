package com.sbnvw.artemis.animal_kingdom.traits;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class TraitBehaviour {

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

}
