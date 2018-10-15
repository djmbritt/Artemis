package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

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

}
