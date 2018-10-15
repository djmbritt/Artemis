package com.sbnvw.artemis.io;

import java.util.ArrayList;

/**
 * 
 * @author djmbritt
 * @param <T> Either IOUsers or IOAnimal
 */
public class IOContext <T>{
    private IOStrategy iOStrategy;

    /**
     * Constructor for the use of the strategy pattern for the loading or saving Users/Animals from disk.
     * @param iOStrategy 
     */
    public IOContext(IOStrategy iOStrategy) {
        this.iOStrategy = iOStrategy;
    }

    /**
     * Save UserLogin or Animal objects to disk.
     * Appends object to an ArrayList.
     * Saves to animal.dat or user.dat
     * @param o Animal or UserInformation
     */
    public void save(T o){
        iOStrategy.saveData(o);
    }
    
    /**
     * Load Userlogin or Animal Object from disk.
     * Returns ArrayList of the specified type when IOContext class is instantiated.
     * @return ArrayList<Animal> or ArrayList<UserInformation>
     */
    public ArrayList<T> load(){
        return iOStrategy.loadData();
    }
    
    /**
     * Return the size of the arrayList.
     * @return int representing the size of the arrayList.
     */
    public int size(){
        return iOStrategy.size();
    }
    
}
