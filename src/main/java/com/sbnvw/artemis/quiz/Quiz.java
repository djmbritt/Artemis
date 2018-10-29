package com.sbnvw.artemis.quiz;

/**
 * This interface will provide the component role in the Composite design
 * pattern. It will include methods for the composite and leafs.
 *
 * @author Donovan Schaafsma
 */
public interface Quiz {

    /**
     *
     * @param name
     */
    public void questionTypeName(String name);

    /**
     *
     * @return
     */
    public String getQuestionTypeName();

}
