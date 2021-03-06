/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.io;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
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
public class IOClassifications implements Serializable {

    private static final String FILELOCATION = "classifications.dat";

    public void saveData(List<Classification> a) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILELOCATION))) {

            oos.writeObject(a);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOClassifications.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Classification> loadData() {
        ArrayList<Classification> list = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILELOCATION))) {
            list = (ArrayList<Classification>) (List<Classification>) ois.readObject();
        } catch (Exception ex) {
            Logger.getLogger(IOClassifications.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }
}
