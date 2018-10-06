package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.actinopterygii;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.Chordate;

/**
 *
 * @author Marcel van Wilgenburg
 */
public abstract class Actinopterygii extends Chordate {
    
    private static int Actinopterygii;
    private final int ActinopterygiiID;

    public Actinopterygii(String name) {
        super(name);
        this.ActinopterygiiID = Actinopterygii;
        Actinopterygii++;
    }

    public static int getActinopterygii() {
        return Actinopterygii;
    }

    public int getActinopterygiiID() {
        return ActinopterygiiID;
    }
    
        
    

}
