package com.sbnvw.artemis.io;

import com.sbnvw.artemis.account.UserInformation;
import com.sbnvw.artemis.account.UserLogin;
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
public class IOUsers implements IOStrategy<UserInformation>, Serializable {

//    private static final long serialVersionUID = 6529685098267757690L;
    private static final String USERFILELOCATION = "users.dat";
    private  ArrayList<UserInformation> users = loadData();

    @Override
    public void saveData(UserInformation o) {
        System.out.println("Saving user to disk: " + o.toString());
        users = loadData();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERFILELOCATION))) {
            users.add(o);
            oos.writeObject(users);
//            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(IOUsers.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    @Override
    public ArrayList<UserInformation> loadData() {
        System.out.println("Loading user data from disk.");
        ArrayList<UserInformation> newArrayList = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USERFILELOCATION))) {
            newArrayList.clear();
            newArrayList.addAll((ArrayList<UserInformation>) ois.readObject());
//            ois.close();
        } catch (Exception ex) {
            Logger.getLogger(IOUsers.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);

        }

        return newArrayList;
    }
    
    @Override
    public int size(){
        return users.size();
    }

}
