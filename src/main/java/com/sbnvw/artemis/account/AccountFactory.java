package com.sbnvw.artemis.account;

/**
 *
 * @author djmbritt
 */
public class AccountFactory {

    public AccountFactory() {
    }
    
    public static Account createAccount(String accountType){
        Account accnt = null;
        
        if(accountType.equalsIgnoreCase("sysadmin")){
            accnt = new SystemAdministrator();
            System.out.println("Creating Sysadmin");
        }else if (accountType.equalsIgnoreCase("admin")) {
            accnt = new Administrator();
            System.out.println("Creating Admin");
        } else if (accountType.equalsIgnoreCase("user")) {
            accnt = new User();
            System.out.println("Creating User");
        } else if (accountType.equalsIgnoreCase("guest")) {
            accnt = new Guest();
            System.out.println("Creating Guest");
        } else {
            accnt = new Guest();
            System.out.println("Creating Guest");
        }

        return accnt;
    }

}
