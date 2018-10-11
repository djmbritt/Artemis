package com.sbnvw.artemis.io;

import com.sbnvw.artemis.account.UserInformation;
import com.sbnvw.artemis.account.UserLogin;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class IOReader {

    /**
     * loads the list of animals saved to disk.
     * @return ArrayList<Animal>
     */
    public static ArrayList<Animal> loadAnimalList() {
        ArrayList<Animal> animals = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(IOWriter.fileLocation("animal")))) {
            animals.addAll((ArrayList<Animal>) ois.readObject());
        } catch (Exception ex) {
            Logger.getLogger(IOWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return animals;
    }

    /**
     * load the list of users saved to disk.
     * @return ArrayList<UserInformation>
     */
    public static ArrayList<UserInformation> loadUserList() {
        ArrayList<UserInformation> users = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(IOWriter.fileLocation("user")))) {
            users.addAll((ArrayList<UserInformation>) ois.readObject());
        } catch (Exception ex) {
            Logger.getLogger(IOWriter.class.getName()).log(Level.SEVERE, null, ex);

        }

        return users;
    }

}
