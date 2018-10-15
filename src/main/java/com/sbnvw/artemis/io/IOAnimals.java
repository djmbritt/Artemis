/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.io;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djmbritt
 */
public class IOAnimals implements IOStrategy<Animal>, Serializable {

    private static final String ANIMALFILELOCATION = "animals.dat";
    private ArrayList<Animal> animals = loadData();

    @Override
    public void saveData(Animal o) {
        animals = loadData();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ANIMALFILELOCATION))) {

            animals.add(o);
            oos.writeObject(animals);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOAnimals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Animal> loadData() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ANIMALFILELOCATION))) {
            animals.addAll((ArrayList<Animal>) ois.readObject());
        } catch (Exception ex) {
            Logger.getLogger(IOAnimals.class.getName()).log(Level.SEVERE, null, ex);
        }

        return animals;
    }

    @Override
    public int size(){
        return animals.size();
    }
}
