package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Birds.parrots.oldWorldParrots;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Birds.parrots.Parrots;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class OldWorldParrots extends Parrots {

    private static int OldWorldParrots;
    private final int OldWorldParrotID;

    public OldWorldParrots(String name) {
        super(name);
        this.OldWorldParrotID = OldWorldParrots;
        OldWorldParrots++;
    }

    public int getOldWoldParrotsID() {
        return OldWorldParrotID;
    }

    public static int getOldWorldParrots() {
        return OldWorldParrots;
    }

}
