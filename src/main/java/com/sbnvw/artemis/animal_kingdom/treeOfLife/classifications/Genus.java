package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Genus extends Classification{
    
    private Family family;

    public Genus(String name, Family family) {
        super(name);
        this.family = family;
    }

    public Family getFamily() {
        return family;
    }

    @Override
    public String getName() {
       return super.getName();
    }
    
    
}
