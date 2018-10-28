package com.sbnvw.artemis.animal_kingdom.traits;

import com.sbnvw.artemis.managers.TraitsManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class TraitGroup extends Trait {

    private final List<TraitBehaviour> traitBehaviours = new ArrayList<>();
    private String groupName;

    public TraitGroup(String groupName) {
        this.groupName = groupName;
        TraitsManager.addTraitGroup(this);
    }

    public void addTraitBehaviour(TraitBehaviour t) {
        traitBehaviours.add(t);
        TraitsManager.updateBehaveiors();
    }

    @Override
    public String getName() {
        return this.groupName;
    }

    public List<TraitBehaviour> getTraitBehaviours() {
        return traitBehaviours;
    }

}
