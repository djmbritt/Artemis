package com.sbnvw.artemis.io;

import com.sbnvw.artemis.account.UserInformation;
import com.sbnvw.artemis.account.UserLogin;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djmbritt
 */
public class IOUsers implements IOStrategy<UserInformation> {

    private static final String USERFILELOCATION = "users.dat";

    @Override
    public void saveData(UserInformation o) {
        ArrayList<UserInformation> users = loadData();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERFILELOCATION))) {
            users.add(o);
            oos.writeObject(users);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(IOUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<UserInformation> loadData() {
        ArrayList<UserInformation> users = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERFILELOCATION))) {
            users.addAll((ArrayList<UserInformation>) ois.readObject());
        } catch (Exception ex) {
            Logger.getLogger(IOUsers.class.getName()).log(Level.SEVERE, null, ex);

        }

        return users;
    }

}
