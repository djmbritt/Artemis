/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.quiz.QuestionGroup;
import com.sbnvw.artemis.quiz.Quiz;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author donovan
 */
public class MakeNewQuizController implements Initializable {
    
    @FXML
    private TextField textfieldQuestion;
    
    @FXML
    private TextField textfieldAnswer;
    
    @FXML
    private TextField textfieldGroup;
    
    @FXML
    private ListView<Quiz> questionList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void updateList(){
        questionList.getItems().clear();
        List<Quiz> quizList = QuestionGroup.getQuiz();
        
    }
    
}
