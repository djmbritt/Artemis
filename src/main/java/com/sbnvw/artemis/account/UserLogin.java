/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.account;

import java.io.Serializable;

/**
 *
 * @author djmbritt
 */
public abstract class UserLogin implements Serializable {

    private static Integer userID = 001;
    private String password;

    public UserLogin(String password) {
        System.out.println("AbstractClass AccountLogin Creation: UserID: " + userID);
        this.password = password;
        userID = userID++;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getUserPassword() {
        return this.password;
    }

    public void setuserPassword(String password) {
        this.password = password;
    }

}
