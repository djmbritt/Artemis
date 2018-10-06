package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.actinopterygii.salmonidae;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.actinopterygii.Actinopterygii;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Salmonidae extends Actinopterygii {
    
    private static int salmonidae;
    private final int salmonidaeID;

    public Salmonidae(String name) {
        super(name);
        this.salmonidaeID = salmonidae;
        salmonidae++;
    }

    public static int getSalmonidae() {
        return salmonidae;
    }

    public int getSalmonidaeID() {
        return salmonidaeID;
    }
    
    

}
