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
public interface ArticleManagement {

    public abstract void createArticle();

    public abstract void readArticle();

    public abstract void updateArticle();

    public abstract void deleteArticle();

    public abstract void suggestArticle();

}
