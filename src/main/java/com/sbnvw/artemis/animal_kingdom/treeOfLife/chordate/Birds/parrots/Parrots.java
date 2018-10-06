package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Birds.parrots;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Birds.Birds;

/**
 *
 * @author Marcel van Wilgenburg
 */
public abstract class Parrots extends Birds {

    private static int parrots;
    private final int parrotID;

    public Parrots(String name) {
        super(name);
        this.parrotID = parrots;
        parrots++;
    }

    public int getParrotID() {
        return parrotID;
    }

    public static int getParrots() {
        return parrots;
    }

}
