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
        QuestionGroup.typeName = typeName;
        QuestionGroup.quiz = new ArrayList<>();
    }
    
    public void addQuestionToGroup(Quiz question) {
        QuestionGroup.quiz.add(question);
    }
    
    public void removeQuestion(Quiz question) {
        QuestionGroup.quiz.remove(question);
    }
    
    public Question getQuestion(int questionIndex) {
        return (Question)QuestionGroup.quiz.get(questionIndex);
    }
    
    public void printQuestions() {
        for (int i = 0; i < QuestionGroup.quiz.size(); i++) {
            System.out.println(QuestionGroup.quiz.get(i));
        }
    }
    
    public static List<Quiz> getQuiz() {
        return QuestionGroup.quiz;
    }
    
    public static String getTypeName() {
        return QuestionGroup.typeName;
    }
    
    @Override
    public void questionTypeName(String name) {
        QuestionGroup.typeName = name;
    }

    @Override
    public String getQuestionTypeName() {
        return QuestionGroup.typeName;
    }

}
