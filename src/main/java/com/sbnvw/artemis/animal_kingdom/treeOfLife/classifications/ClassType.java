package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

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

}
