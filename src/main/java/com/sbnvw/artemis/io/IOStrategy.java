/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.io;

import java.util.ArrayList;

/**
 *
 * @author djmbritt
 */
public interface IOStrategy <T>{

    public void saveData(T o);
    public ArrayList<T> loadData();
}
