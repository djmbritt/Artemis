package com.sbnvw.artemis.animal_kingdom.traits;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class TraitBehaviour extends Trait{

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

    public void addTraitBehaviour(TraitBehaviour t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
