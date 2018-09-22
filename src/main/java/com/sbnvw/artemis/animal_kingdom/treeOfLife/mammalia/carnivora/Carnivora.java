package com.sbnvw.artemis.animal_kingdom.treeOfLife.mammalia.carnivora;

import com.sbnvw.artemis.animal_kingdom.traits.diet.Diet;
import com.sbnvw.artemis.animal_kingdom.traits.diet.Eats_Meat;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.mammalia.Mammalia;

public abstract class Carnivora extends Mammalia {

    private static int carnivoras;
    private final int carnivoraID;
    private final Diet diet = new Eats_Meat();

    public Carnivora(String name) {

        super(name);
        carnivoraID = carnivoras;
        carnivoras++;
    }

    public Diet getDiet() {
        return diet;
    }
    
    
}
