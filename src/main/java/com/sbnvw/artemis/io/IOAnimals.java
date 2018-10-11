/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.io;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djmbritt
 */
public class IOAnimals implements IOStrategy<Animal> {

    private static final String ANIMALFILELOCATION = "animals.dat";
    private static ArrayList<Animal> animals = new ArrayList<>();

    @Override
    public void saveData(Animal o) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ANIMALFILELOCATION));) {

            animals.add(o);
            oos.writeObject(animals);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Animal> loadData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
