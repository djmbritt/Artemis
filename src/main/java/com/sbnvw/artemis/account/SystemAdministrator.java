package com.sbnvw.artemis.account;

import com.sbnvw.artemis.io.IOWriter;
import javafx.scene.image.Image;
import java.util.Date;

/**
 *
 * @author djmbritt
 */
public class SystemAdministrator extends UserInformation {

    /**
     * Use singleton design pattern to allow the creation of only one instance of the systemAdministrator class.
     * Using the public static final method
     */
    public static final SystemAdministrator INSTANCE = new SystemAdministrator();
    
    private SystemAdministrator(){
    
        super("sysadmin", "sysadminpass", "System", "Administrator", 
                new Date(System.currentTimeMillis()), "androgynous", 
                "sysadmin@artemis.nl", "0205954955", "Wibautstraat", "3", "b", 
                "1091 GH", null);
        
        IOWriter.saveUser(this);
    
    }
    

    /**
     * User Management
     */
    @Override
    public void createUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        
        return String.format("\n%s\n%s %s\n%s\n%s\n%s\n%s %s%s\n%s\n%s\n%s", 
                super.toString(),
                "Name:\t\t " + getFirstName() , getLastName(),
                "UserID:\t\t " + getUserID(),
                "UserName:\t " + getUserName(),
                "Password:\t " + getUserPassword(),
                "Address:\t " + getAddres() , getHouseNumber() , getAddition(),
                "PostalCode:\t " + getPostalCode(),
                "Email:\t\t " + getEmail(),
                "PhoneNumber:\t " + getPhoneNumber());
    }

}
