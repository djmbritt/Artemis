package com.sbnvw.artemis.mediator;

/**
 *
 * @author Donovan Schaafsma
 */
public class ConcreteMediator implements Mediator{
    private static ConcreteMediator concreteMediator = null;
    
    private ConcreteMediator(){
        
    }
    
    private static void createConcreteMediator() {
        if (concreteMediator == null) {
            concreteMediator = new ConcreteMediator();
        }
    }
    
    public static ConcreteMediator getConcreteMediator(){
        if (concreteMediator == null) {
            createConcreteMediator();
        }
        return concreteMediator;
    }

    @Override
    public void getAnimals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAnimalProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getUserProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
