package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public abstract class Classification {

    private String Name;
    private List<Trait> traits = new ArrayList();

    public Classification(String Name) {
        this.Name = Name;
    }

    public String getName() {
        return Name;
    }

    public void addTrait(Trait trait) {

        this.traits.add(trait);

    }

    public List<Trait> getTraits() {
        return traits;
    }

    public Trait getTraitByType(TraitGroup traitGroup) {

        for (int i = 0; i < traits.size(); i++) {
            if (traits.get(i) instanceof TraitGroup) {
                return traits.get(i);
            }
        }
        return null;
    }

}
