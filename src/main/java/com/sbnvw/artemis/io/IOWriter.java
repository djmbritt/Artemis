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
 * @author Marcel van Wilgenburg
 */
public class IOWriter {
    
    private static ArrayList<Animal> animals = new ArrayList<>();
    
    public static void saveAnimal(Animal animal) {
        
        try (FileOutputStream fos = new FileOutputStream("animals.dat"); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            
            animals.add(animal);
            oos.writeObject(animals);
            
        } catch (IOException ex) {
            Logger.getLogger(IOWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
