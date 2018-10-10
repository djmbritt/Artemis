package com.sbnvw.artemis.io;

import com.sbnvw.artemis.account.UserLogin;
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

    private static final String ANIMALFILELOCATION = "animals.dat";
    private static ArrayList<Animal> animals = new ArrayList<>();
    
    private static final String USERFILELOCATION = "users.dat";
    private static ArrayList<UserLogin> users = new ArrayList<>();
    
    public static String fileLocation(String userOrAnimal){
        if (userOrAnimal.equalsIgnoreCase("animal")) {
            return ANIMALFILELOCATION;
        } else if (userOrAnimal.equalsIgnoreCase("user")) {
            return USERFILELOCATION;
        }else{
            return null;
        }
    }

    public static void saveAnimal(Animal animal) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ANIMALFILELOCATION));) {

            animals.add(animal);
            oos.writeObject(animals);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void saveUser(UserLogin user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERFILELOCATION));) {
            users.add(user);
            oos.writeObject(users);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(IOWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
