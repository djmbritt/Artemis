package com.sbnvw.artemis.io;

import com.sbnvw.artemis.quiz.Question;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Donovan Schaafsma
 */
public class IOQuiz {

    private final String QUIZFILELOCATION = "quiz.dat";
    private ArrayList<Question> question;
    private File file = new File(QUIZFILELOCATION);

    /**
     * TODO: reading of the Arraylist<Question> o and adding to the this.question.
     *
     * @param o
     */
    public void saveData(ArrayList<Question> o) {
        question = loadData();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(QUIZFILELOCATION))) {

            oos.writeObject(question);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOAnimals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Question> loadData() {

        if (!file.exists()) {
            return question = new ArrayList<>();

        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(QUIZFILELOCATION))) {
            question.addAll((ArrayList<Question>) ois.readObject());
        } catch (Exception ex) {
            Logger.getLogger(IOAnimals.class.getName()).log(Level.SEVERE, null, ex);
        }

        return question;
    }

    /**
     *
     * @return
     */
    public int size() {
        return question.size();
    }

}
