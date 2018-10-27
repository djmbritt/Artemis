package com.sbnvw.artemis.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Donovan Schaafsma
 *
 * This class is the composite element in the Composite design pattern.
 */
public class QuestionGroup implements Quiz {

    private String typeName;

    private List<Quiz> quiz;

    public QuestionGroup(String typeName) {
        this.typeName = typeName;
        quiz = new ArrayList<>();
    }
    
    public void addQuestionToGroup(Quiz question) {
        quiz.add(question);
    }
    
    public void removeQuestion(Quiz question) {
        quiz.remove(question);
    }
    
    public void printQuestions() {
        for (int i = 0; i < quiz.size(); i++) {
            System.out.println(quiz.get(i));
        }
    }
    
    public List<Quiz> getQuiz() {
        return quiz;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    
    @Override
    public void questionTypeName(String name) {
        this.typeName = name;
    }

}
