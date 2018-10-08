package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Birds;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Chordate;

/**
 *
 * @author Marcel van Wilgenburg
 */
public abstract class Birds extends Chordate {
    private static int Birds;
    private final int birdID;

    public Birds(String name) {
        super(name);
        this.birdID = Birds;
        Birds++;
    }

    public int getBirdID() {
        return birdID;
    }

    public static int getBirds() {
        return Birds;
    }
    
    

}
