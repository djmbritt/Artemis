/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.account;

import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;
import java.io.Serializable;

/**
 *
 * @author djmbritt
 */
public abstract class UserLogin implements Serializable {

    private static int userID = new IOContext(new IOUsers()).size();
    private String password;
    private String accountType;

    public UserLogin(String password, String accountType) {
        System.out.println("AbstractClass AccountLogin Creation: UserID: " + userID);
        this.password = password;
        this.accountType = accountType;
        userID = ++userID;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String acccountType) {
        this.accountType = acccountType;
    }

}
