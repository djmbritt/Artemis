package com.sbnvw.artemis.account;

import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;
import java.util.Date;
import javafx.scene.image.Image;

/**
 *
 * @author djmbritt
 */
public class AccountFactory {

    public static UserLogin createAccount(String accountType) {
        UserLogin accnt = null;

        if (accountType.equalsIgnoreCase("admin")) {

            /**
             * Admin should only be created by a sysadmin.
             */
            accnt = new Administrator();
            System.out.println("Creating Admin");

        } else if (accountType.equalsIgnoreCase("user")) {

            accnt = new User();
            System.out.println("Creating User");

        } else if (accountType.equalsIgnoreCase("guest")) {

            accnt = new Guest();
            System.out.println("Creating Guest");

        } 

        new IOContext(new IOUsers()).save(accnt);
        return accnt;
    }

    /**
     * Account factory method for returning a new account type. Also save the
     * newly created user to the users.dat file with IOWriter.saveUser().
     *
     * @param accountType available: {"admin", "user", "guest"}
     * @return object of type UserLogin
     */
    public static UserInformation createAccount(
            String accountType, 
            String password, String userName, String firstName,
            String lastName, Date dateOfBirth, String sex, String email,
            String phoneNumber, String addres, String houseNumber, String addition,
            String postalCode, String country, Image profilePicture) {

        //TODO implement the passing of the parameters for the construction of the account classes.
        //TODO implement the saving of the users in this class.
        UserInformation accnt = null;

        if (accountType.equalsIgnoreCase("admin")) {

            /**
             * Admin should only be created by a sysadmin.
             */
            accnt = new Administrator(password, userName, firstName,
                    lastName, dateOfBirth, sex, email,
                    phoneNumber, addres, houseNumber, addition,
                    postalCode, country, profilePicture);
            System.out.println("Creating Admin");

        } else if (accountType.equalsIgnoreCase("user")) {

            accnt = new User(password, userName, firstName,
                    lastName, dateOfBirth, sex, email,
                    phoneNumber, addres, houseNumber, addition,
                    postalCode, country, profilePicture);
            System.out.println("Creating User");

        } 

        new IOContext(new IOUsers()).save(accnt);
        return accnt;
    }

}
