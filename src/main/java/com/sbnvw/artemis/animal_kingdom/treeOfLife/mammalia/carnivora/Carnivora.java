package com.sbnvw.artemis.animal_kingdom.treeOfLife.mammalia.carnivora;

import com.sbnvw.artemis.animal_kingdom.traits.diet.Diet;
import com.sbnvw.artemis.animal_kingdom.traits.diet.Eats_Meat;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.mammalia.Mammalia;

public abstract class Carnivora extends Mammalia {

    private static int carnivoras;
    private final int carnivoraID;

    public Carnivora(String name) {

        super(name);
        carnivoraID = carnivoras;
        carnivoras++;

    }

    @Override
    public void setDiet(Diet diet) {
        super.setDiet(new Eats_Meat());
    }

}
