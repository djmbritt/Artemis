package com.sbnvw.artemis.mediator;

/**
 *
 * @author Donovan Schaafsma
 */
public interface Mediator {
    
    /**
     * We want methods to handle getters and setters that give the desired info
     * to the desired account. 
     * So we get the information from the animals and we
     * give them to the accounts. Some accounts can access certain animals that 
     * other accounts can't.
    */
    public void getAnimals();
    public void getAnimalProfile();
    public void getUsers();
    public void getUserProfile();
    
    
}
