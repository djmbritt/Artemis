package com.sbnvw.artemis.managers;

/**
 *
 * @author Marcel van Wilgenburg
 */
public interface Observable {

    void attach(Object object);

    void detach(Object object);

    void alert();

}
