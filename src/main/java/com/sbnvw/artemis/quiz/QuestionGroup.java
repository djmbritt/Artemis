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

    private static String typeName;
    private static List<Quiz> quiz;

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
    
    public static List<Quiz> getQuiz() {
        return quiz;
    }
    
    public static String getTypeName() {
        return typeName;
    }
    
    public static void setTypeName(String aTypeName) {
        typeName = aTypeName;
    }
    
    @Override
    public void questionTypeName(String name) {
        this.typeName = name;
    }

}
