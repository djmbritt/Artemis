package com.sbnvw.artemis.account;

/**
 *
 * @author djmbritt
 */
public class AccountFactory {

    public AccountFactory() {
    }
    
    public static GetAccount createAccount(String accountType){
        GetAccount accnt = null;
        
        if(accountType.equalsIgnoreCase("sysadmin")){
            
            /**
             * There should be only three sysadmins created at the beginning.
             * Potential use of singleton pattern here?
             */
            accnt = new SystemAdministrator();
            System.out.println("Creating Sysadmin");
            
        }else if (accountType.equalsIgnoreCase("admin")) {
            
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

        return null;
    }

}
