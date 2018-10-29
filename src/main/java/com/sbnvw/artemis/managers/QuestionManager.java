package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.io.IOQuiz;
import com.sbnvw.artemis.quiz.Question;
import java.util.ArrayList;

/**
 *
 * @author Donovan Schaafsma
 */
public class QuestionManager {

    private static QuestionManager qm;
    private static ArrayList<Question> questionManager = new ArrayList<>();
    private static IOQuiz ioq = new IOQuiz();

    private QuestionManager() {
    }

    private synchronized static void createInstance() {
        if (qm == null) {
            qm = new QuestionManager();
        }
    }

    public static QuestionManager getInstance() {
        if (qm == null) {
            createInstance();
        }
        return qm;
    }

    public QuestionManager getManager() {
        return getInstance();
    }

    public void addQuestion(Question q) {
        questionManager.add(q);
    }

    public void removeQuestion(int qIndex) {
        questionManager.remove(qIndex);
    }

    public void saveQuestions() {
        ioq.saveData(questionManager);
    }

    public ArrayList<Question> loadQuestions() {
        return ioq.loadData();
    }

}
