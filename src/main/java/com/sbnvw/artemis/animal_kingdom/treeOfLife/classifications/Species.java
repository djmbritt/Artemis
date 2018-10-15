package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

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

}
