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

    /**
     * return File location path of animal or user.
     * @param userOrAnimal {"user", "animal"}
     * @return 
     */
    public static String fileLocation(String userOrAnimal) {
        if (userOrAnimal.equalsIgnoreCase("animal")) {
            return ANIMALFILELOCATION;
        } else if (userOrAnimal.equalsIgnoreCase("user")) {
            return USERFILELOCATION;
        } else {
            return null;
        }
    }

    /**
     * Save animal to disk, saves it in the location specified in IOWriter::ANIMALFILELOCATION
     * @param animal 
     */
    public static void saveAnimal(Animal animal) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ANIMALFILELOCATION));) {

            animals.add(animal);
            oos.writeObject(animals);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Save user to disk, saves it in the location specified in IOWriter::USERFILELOCATION
     * @param user of type USERLOGIN
     */
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
