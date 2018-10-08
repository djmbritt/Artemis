package com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.canidae.dogs;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.canidae.Canidae;

public class Dog extends Canidae {

    private static int dogs;
    private final int dogID;

    public Dog(String name) {
        super(name);
        this.dogID = dogs;
        dogs++;
    }

    public int getDogID() {
        return dogID;
    }

    public static int getDogs() {
        return dogs;
    }

}
