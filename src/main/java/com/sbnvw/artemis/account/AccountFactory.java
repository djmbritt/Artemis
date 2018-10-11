package com.sbnvw.artemis.account;

import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;


/**
 *
 * @author djmbritt
 */
public class AccountFactory {

    public AccountFactory() {
    }

    /**
     * Account factory method for returning a new account type. Also save the
     * newly created user to the users.dat file with IOWriter.saveUser().
     *
     * @param accountType available: {"admin", "user", "guest"}
     * @return object of type UserLogin
     */
    public static UserLogin createAccount(String accountType) {
        
        //TODO implement the passing of the parameters for the construction of the account classes.
        //TODO implement the saving of the users in this class.
        
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

        } else {

            return null;

        }
        
        new IOContext(new IOUsers()).save(accnt);
        return accnt;
    }

}
