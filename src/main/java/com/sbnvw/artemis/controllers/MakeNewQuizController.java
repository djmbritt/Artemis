/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.io.IOQuiz;
import com.sbnvw.artemis.quiz.Question;
import com.sbnvw.artemis.quiz.QuestionGroup;
import com.sbnvw.artemis.quiz.Quiz;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author donovan
 */
public class MakeNewQuizController implements Initializable {
    @FXML
    private TextField textfieldGroup;
    
    @FXML 
    private TextField textfieldQuestion;
    
    @FXML
    private TextField textfieldAnswer;
    
    @FXML
    private ListView<Question> questionList;

    @FXML
    private Button btnSave;
    
    private IOQuiz ioQ;
    private Question q;
    private String question;
    private List<Question> quiz;
    private Question selectedQuiz;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        q = new Question();
        ioQ = new IOQuiz();
        quiz = loadQuizzes();
        updateList();
    } 
    
    /**
     * Updates the list with quizzes and questions.
     */
    public void updateList() {
        questionList.getItems().clear();
        for (int i = 0; i < quiz.size(); i++) {
            questionList.getItems().add(quiz.get(i));
        }
    }
    
    public void openQuiz(ActionEvent event) throws IOException {
        selectedQuiz = questionList.getSelectionModel().getSelectedItem();
        System.out.println("daggoe");
        if (!(selectedQuiz == null)) {
                    MainApp.loadFXMLFileInNewWindow("/fxml/quizQuestion.fxml", "Question");
                    System.out.println("cattoe");
        }
        
    }
    
    public void initQuizQuestion() {
        selectedQuiz = questionList.getSelectionModel().getSelectedItem();
        QuizQuestionController.setInfo(selectedQuiz.getQuestion(), 
                selectedQuiz.getQuestionTypeName());
    }
    
    public void saveQuizzes(ActionEvent event) {
        q.setQuestion(textfieldQuestion.getText());
        q.setAnswer(textfieldAnswer.getText());
        q.questionTypeName(textfieldGroup.getText());
        ioQ.saveData(q);
        updateList();
    }
    
    public ArrayList<Question> loadQuizzes() {
        return ioQ.loadData();
    }
    
}