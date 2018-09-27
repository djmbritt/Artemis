package com.sbnvw.artemis.animal_kingdom.treeOfLife.mammalia;

import com.sbnvw.artemis.animal_kingdom.traits.diet.Eats_Meat;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;

public abstract class Mammalia extends Animal {

    private static int mammals;
    private int mammalID;

    public int getMammalID() {
        return mammalID;
    }

    public static int getMammals() {
        return mammals;
    }

    public Mammalia(String name) {
        super(name);
        mammalID = mammals;
        mammals++;

    }
}
