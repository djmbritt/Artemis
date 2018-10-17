/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.account;

import javafx.scene.image.Image;
import java.util.Date;

/**
 *
 * @author djmbritt
 */
public class User extends UserInformation implements ArticleManagement {

    public User() {
    }

    public User(String password, String userName, String firstName, 
            String lastName, Date dateOfBirth, String sex, String email, 
            String phoneNumber, String addres, String houseNumber, String addition, 
            String postalCode, String country, Image profilePicture) {
        super(password, "User", userName, firstName, lastName, dateOfBirth, sex, email, 
                phoneNumber, addres, houseNumber, addition, postalCode, country, profilePicture);
    }


    /**
     * Article Management
     */
    @Override
    public void createArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suggestArticle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
