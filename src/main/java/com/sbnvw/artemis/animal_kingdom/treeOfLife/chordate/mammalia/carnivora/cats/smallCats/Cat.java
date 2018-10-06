package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.cats.smallCats;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.cats.Cats;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Cat extends Cats {

    private static int cats;
    private final int catID;

    public Cat(String name) {
        super(name);
        this.catID = cats;
        cats++;
    }

    public int getCatID() {
        return catID;
    }

    public static int getNumberOfCats() {
        return cats;
    }

}
