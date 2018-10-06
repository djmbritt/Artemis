package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;

/**
 *
 * @author Marcel van Wilgenburg
 */
public abstract class Chordate extends Animal {

    private static int Chordates;
    private final int chordateID;

    public Chordate(String name) {
        super(name);
        this.chordateID = Chordates;
        Chordates++;
    }

    public int getChordateID() {
        return chordateID;
    }

    public static int getChordates() {
        return Chordates;
    }

}
