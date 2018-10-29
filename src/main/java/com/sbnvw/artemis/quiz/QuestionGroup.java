package com.sbnvw.artemis.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the composite element in the Composite design pattern.
 *
 * @author Donovan Schaafsma
 */
public class QuestionGroup implements Quiz {

    private static String typeName;
    private static List<Quiz> quiz = new ArrayList<>();

    /**
     *
     * @param typeName
     */
    public QuestionGroup(String typeName) {
        QuestionGroup.typeName = typeName;
    }

    /**
     * Constructor
     *
     */
    public QuestionGroup() {

    }

    /**
     *
     * @param question
     */
    public void addQuestionToGroup(Quiz question) {
        QuestionGroup.quiz.add(question);
    }

    /**
     *
     * @param question
     */
    public void removeQuestion(Quiz question) {
        QuestionGroup.quiz.remove(question);
    }

    /**
     *
     * @param questionIndex
     * @return
     */
    public Question getQuestion(int questionIndex) {
        return (Question) QuestionGroup.quiz.get(questionIndex);
    }

    /**
     *
     */
    public void printQuestions() {
        for (int i = 0; i < QuestionGroup.quiz.size(); i++) {
            System.out.println(QuestionGroup.quiz.get(i));
        }
    }

    /**
     *
     * @return
     */
    public static List<Quiz> getQuiz() {
        return QuestionGroup.quiz;
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
