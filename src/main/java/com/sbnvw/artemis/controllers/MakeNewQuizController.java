package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.managers.QuestionManager;
import com.sbnvw.artemis.quiz.Question;
import com.sbnvw.artemis.quiz.QuestionGroup;
import java.io.IOException;
import java.net.URL;
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
 * @author Donovan Schaafsma
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

    private Question q;
    private QuestionGroup qg;
    private List<Question> quiz;
    private Question selectedQuiz;
    private QuestionManager qm;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        q = new Question();
        qm = QuestionManager.getInstance();
//        updateList();
    }

    /**
     * Updates the list with quizzes and questions.
     */
    public void updateList() {
        questionList.getItems().clear();
        quiz = qm.loadQuestions();
        for (int i = 0; i < quiz.size(); i++) {
            questionList.getItems().add(quiz.get(i));
        }
    }

    /**
     *
     * @param event
     * @throws IOException
     */
    public void openQuiz(ActionEvent event) throws IOException {
        selectedQuiz = questionList.getSelectionModel().getSelectedItem();
        if (!(selectedQuiz == null)) {
            MainApp.loadFXMLFileInNewWindow("/fxml/quizQuestion.fxml", "Question");
        }

    }

    /**
     *
     */
    public void initQuizQuestion() {
        selectedQuiz = questionList.getSelectionModel().getSelectedItem();
        QuizQuestionController.setInfo(selectedQuiz.getQuestion(),
                selectedQuiz.getQuestionTypeName());
    }

    /**
     *
     * @param event
     */
    public void saveQuizzes(ActionEvent event) {
        q.setQuestion(textfieldQuestion.getText());
        q.setAnswer(textfieldAnswer.getText());
        q.questionTypeName(textfieldGroup.getText());
        qg = new QuestionGroup(textfieldGroup.getText());
        qg.addQuestionToGroup(q);
        qm.addQuestion(q);
//        qm.saveQuestions();
//        updateList();
    }

}
