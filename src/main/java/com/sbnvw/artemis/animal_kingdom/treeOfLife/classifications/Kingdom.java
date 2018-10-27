package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Kingdom extends Classification {

    public Kingdom(String Name) {
        super(Name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public List<Trait> getTraits() {
        List trList = new ArrayList();
        for (int i = 0; i < traits.size(); i++) {
            trList.add(traits.get(i));
        }

        return trList;
    }

}
