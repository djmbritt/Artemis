package com.sbnvw.artemis.animal_kingdom.treeOfLife.Birds;

import com.sbnvw.artemis.animal_kingdom.traits.fur.Feathers;
import com.sbnvw.artemis.animal_kingdom.traits.fur.Fur;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Birds extends Animal {

    public Birds(String name) {
        super(name);
    }

    @Override
    public void setFur(Fur fur) {
        super.setFur(new Feathers());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
    
    

}
