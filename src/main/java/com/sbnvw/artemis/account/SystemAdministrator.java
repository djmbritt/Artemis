package com.sbnvw.artemis.account;

import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;
import java.util.Date;

/**
 *
 * @author djmbritt
 */
public class SystemAdministrator extends UserInformation {

    /**
     * Use singleton design pattern to allow the creation of only one instance
     * of the systemAdministrator class. Using the public static final method
     *
     */
    
    /**
     * Instantiation of System Administrator.
     */
    private static final SystemAdministrator INSTANCE = new SystemAdministrator();

    /**
     * Private Constructor
     */
    private SystemAdministrator() {

        super(
                "sysadmin",                             //User
                 "sysadminpass",                        //password
                 "System",                              //FirstName
                 "Administrator",                       //LastName
                 new Date(System.currentTimeMillis()),  //DateDateAccount
                 "androgynous",                         //Sex
                 "sysadmin@artemis.nl",                 //Email
                 "0205954955",                          //Telephone
                 "Wibautstraat",                        //Address
                 "3",                                   //HouseNumber
                 "b",                                   //Addition
                 "1091 GH",                             //PostalCode
                 null                                   //ProfileImage
        );
        
        new IOContext(new IOUsers()).save(this.INSTANCE);

    }

    /**
     * Sole method to be able to get to SystemAdmin Instance.
     * @return 
     */
    public static SystemAdministrator getInstance() {
        return INSTANCE;
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

    
    /**
     * 
     * @return String representation of Instance System Administrator
     */
    @Override
    public String toString() {

        return String.format("\n%s\n%s %s\n%s\n%s\n%s\n%s %s%s\n%s\n%s\n%s",
                super.toString(),
                "Name:\t\t " + getFirstName(), getLastName(),
                "UserID:\t\t " + getUserID(),
                "UserName:\t " + getUserName(),
                "Password:\t " + getUserPassword(),
                "Address:\t " + getAddres(), getHouseNumber(), getAddition(),
                "PostalCode:\t " + getPostalCode(),
                "Email:\t\t " + getEmail(),
                "PhoneNumber:\t " + getPhoneNumber());
    }

}
