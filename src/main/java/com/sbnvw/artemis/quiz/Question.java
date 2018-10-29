package com.sbnvw.artemis.quiz;

import java.io.Serializable;

/**
 *
 * @author Donovan Schaafsma
 *
 * This class is the leaf in the composite design pattern.
 */
public class Question implements Quiz, Serializable {

    private String typeName;
    private String question;
    private String answer;
    private QuestionGroup q;

    /**
     *
     * @param question
     */
    public void Question(String question) {
        this.question = question;
        q = new QuestionGroup();
    }

    /**
     *
     * @param question
     * @param group
     */
    public void Question(String question, String group) {
        this.question = question;
        questionTypeName(group);
        this.q = new QuestionGroup(this.typeName);
    }

    /**
     *
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     *
     * @return
     */
    public String getAnswer() {
        return answer;
    }

    /**
     *
     * @return
     */
    public String getQuestion() {
        return question;
    }

    /**
     *
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public void questionTypeName(String name) {
        this.typeName = name;
    }

    @Override
    public String getQuestionTypeName() {
        return this.typeName;
    }

    @Override
    public String toString() {
        return this.question;
    }

}
