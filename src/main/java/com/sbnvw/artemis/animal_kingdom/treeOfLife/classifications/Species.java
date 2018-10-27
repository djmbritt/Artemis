package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Species extends Classification {
    
    private Genus genus;
    
    public Species(String name, Genus genus) {
        super(name);
        this.genus = genus;
    }
    
    public Genus getGenus() {
        return genus;
    }
    
    @Override
    public String getName() {
        return super.getName();
    }
    
    /**
     *
     * @return
     */
    @Override
    public List getTraits() {
        List trList = new ArrayList();
        List myTraits = getGenus().getTraits();
        for (int i = 0; i < traits.size(); i++) {
            trList.add(traits.get(i));
        }
        for (int i = 0; i < myTraits.size(); i++) {
            trList.add(myTraits.get(i));
        }
        
        return trList;
    }
    
}
