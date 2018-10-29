/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author donovan
 */
public class QuizQuestionController implements Initializable {

    @FXML
    private Button btnCancel;
    @FXML
    private Button btnNext;
    @FXML
    private static Label questionText;
    @FXML
    private TextArea answerText;
    @FXML
    private static Label groupTypeName;

    MakeNewQuizController m = new MakeNewQuizController();
    
    public static void setInfo(String question, String group){
        questionText.setText(question);
        groupTypeName.setText(group);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        m.initQuizQuestion();
    }    
    
}
