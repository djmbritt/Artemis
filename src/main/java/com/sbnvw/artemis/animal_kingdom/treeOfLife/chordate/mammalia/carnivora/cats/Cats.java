package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.cats;

import com.sbnvw.artemis.animal_kingdom.traits.diet.Diet;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.Carnivora;

/**
 *
 * @author Marcel van Wilgenburg
 */
public abstract class Cats extends Carnivora {

    private static int cats;
    private int catsID;

    public Cats(String name) {
        super(name);
        this.catsID = cats;
        cats++;
    }

    public int getCatID() {
        return catsID;
    }

    public static int getCats() {
        return cats;
    }


}
