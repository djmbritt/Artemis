package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.canidae;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.Carnivora;

public abstract class Canidae extends Carnivora {

    private static int candiae;
    private final int canidaeID;

    public Canidae(String name) {
        super(name);
        this.canidaeID = candiae;
        candiae++;

    }

    public static int getCandiae() {
        return candiae;
    }

    public int getCanidaeID() {
        return canidaeID;
    }

}
