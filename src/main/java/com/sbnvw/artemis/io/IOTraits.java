/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.io;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author djmbritt
 */
public class IOTraits implements Serializable {

    private static final String TRAITSLOCATION = "traits.dat";

    public void saveData(List<TraitGroup> a) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(TRAITSLOCATION))) {

            oos.writeObject(a);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOTraits.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<TraitGroup> loadData() {
        ArrayList<TraitGroup> list = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(TRAITSLOCATION))) {
            list = (ArrayList<TraitGroup>) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(IOTraits.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
