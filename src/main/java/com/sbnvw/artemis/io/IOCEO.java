package com.sbnvw.artemis.io;

import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class IOCEO {

    private static final String TRAITSLOCATION = "data.dat";

    public void saveData(List<ArrayList> a) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TRAITSLOCATION))) {

            oos.writeObject(a);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOTraits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ArrayList> loadData() {
        ArrayList<ArrayList> list = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TRAITSLOCATION))) {
            list = (ArrayList<ArrayList>) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(IOTraits.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
