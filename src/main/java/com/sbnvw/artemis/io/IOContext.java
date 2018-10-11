package com.sbnvw.artemis.io;

import java.util.ArrayList;

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
