/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.account;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author djmbritt
 */
public class Guest extends Account implements ArticleManagement{

    public Guest(String password, String userName, String firstName, String lastName, Date dateOfBirth, String sex, String email, int phoneNumber, String addres, int houseNumber, String addition, String postalCode, Image profilePicture) {
        super(password, userName, firstName, lastName, dateOfBirth, sex, email, phoneNumber, addres, houseNumber, addition, postalCode, profilePicture);
    }

    @Override
    public void modifyArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createAnimal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suggestArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void viewArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
