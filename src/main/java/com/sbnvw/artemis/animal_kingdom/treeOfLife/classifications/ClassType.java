package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class ClassType extends Classification {

    private Phylum phylum;

    public ClassType(String name, Phylum phylum) {
        super(name);
        this.phylum = phylum;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Phylum getPhylum() {
        return phylum;
    }

    @Override
    public List<Trait> getTraits() {
        List trList = new ArrayList();
        List myTraits = getPhylum().getTraits();
        for (int i = 0; i < traits.size(); i++) {
            trList.add(traits.get(i));
        }
        for (int i = 0; i < myTraits.size(); i++) {
            trList.add(myTraits.get(i));
        }
        return trList;
    }

}
