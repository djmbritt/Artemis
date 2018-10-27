package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Phylum extends Classification {

    private Kingdom kingdom;

    public Phylum(String name, Kingdom kingdom) {
        super(name);
        this.kingdom = kingdom;
    }

    public Kingdom getKingdom() {
        return kingdom;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public List<Trait> getTraits() {
        List trList = new ArrayList();
        List myTraits = getKingdom().getTraits();
        for (int i = 0; i < traits.size(); i++) {
            trList.add(traits.get(i));
        }
        for (int i = 0; i < myTraits.size(); i++) {
            trList.add(myTraits.get(i));
        }

        return trList;
    }

}
