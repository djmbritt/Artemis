package com.sbnvw.artemis.io;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author djmbritt
 */
public class IOContext <T>{
    private IOStrategy iOStrategy;

    public IOContext(IOStrategy iOStrategy) {
        this.iOStrategy = iOStrategy;
    }

    public void save(T o){
        iOStrategy.saveData(o);
    }
    
    public ArrayList<T> load(){
        return iOStrategy.loadData();
    }
    
}
