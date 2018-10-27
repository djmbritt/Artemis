package com.sbnvw.artemis.quiz;

/**
 *
 * @author Donovan Schaafsma
 *
 * This class is the leaf in the composite design pattern.
 */
public class Question implements Quiz {

    private String typeName;
    private String question;
    private String answer;

    public void question(String question) {
        this.question = question;
    }

    public String getQuestionType() {
        return this.typeName;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public void questionTypeName(String name) {
        this.typeName = name;
    }

}
