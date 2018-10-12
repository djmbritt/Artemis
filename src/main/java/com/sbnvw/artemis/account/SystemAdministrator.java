package com.sbnvw.artemis.account;

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
    
/*    Lazy initialization method
    private static SystemAdministrator systemAdministrator = null;
    private synchronized static void createInstance() {
        if (systemAdministrator == null) {
            systemAdministrator = new SystemAdministrator();
        }
    }

    public static SystemAdministrator getInstance() {
        if (systemAdministrator == null) {
            createInstance();
        }
        return systemAdministrator;
    }
*/

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

}
