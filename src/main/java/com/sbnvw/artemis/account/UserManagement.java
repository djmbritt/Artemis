/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.account;

/**
 *
 * @author djmbritt
 */
public interface UserManagement {

    public abstract void createUser();

    public abstract void readUser();

    public abstract void updateUser();

    public abstract void deleteUser();

}
