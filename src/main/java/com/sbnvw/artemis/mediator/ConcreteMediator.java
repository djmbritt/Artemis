package com.sbnvw.artemis.mediator;

import com.sbnvw.artemis.account.Administrator;
import com.sbnvw.artemis.account.Guest;
import com.sbnvw.artemis.account.SystemAdministrator;
import com.sbnvw.artemis.account.User;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import java.util.ArrayList;

/**
 *
 * @author Donovan Schaafsma
 */
public class ConcreteMediator implements Mediator{
    
    SystemAdministrator sys;
    Administrator admin;
    User user;
    Guest guest;
    Animal animal;
    
    public void registerSystemAdmin (SystemAdministrator sys) {
        this.sys = sys;
    }
    
    public void registerAdmin (Administrator admin) {
        this.admin = admin;
    }
    
    public void registerUser (User user) {
        this.user = user;
    }
    
    public void registerGuest (Guest guest) {
        this.guest = guest;
    }
    
    public void registerAnimal (Animal animal) {
        this.animal = animal;
    }
    
    public ArrayList getUserInformation(String user, SystemAdministrator sys) {
        ArrayList list = new ArrayList();
        if (this.sys.equals(sys) && this.user.getFirstName().equalsIgnoreCase(user)) {
            list.add(this.user.getFirstName());
            list.add(this.user.getLastName());
            list.add(this.user.getPhoneNumber());
        }
        
        return list;
    }
    
    public ArrayList getAdminInformation(Administrator admin, SystemAdministrator sys) {
        ArrayList list = new ArrayList();
            list.add(admin.getFirstName());
            list.add(admin.getLastName());
            list.add(admin.getPhoneNumber());
        
        return list;
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
