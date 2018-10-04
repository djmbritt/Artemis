package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Chordate;

public abstract class Mammalia extends Chordate {

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
