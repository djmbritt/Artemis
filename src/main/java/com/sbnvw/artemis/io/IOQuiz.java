package com.sbnvw.artemis.io;

import com.sbnvw.artemis.quiz.Question;
import com.sbnvw.artemis.quiz.Quiz;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
public class IOQuiz{
    
    private static final String QUIZFILELOCATION = "quiz.dat";
    private ArrayList<Question> question = new ArrayList<>();
    private File file = new File(QUIZFILELOCATION);


    public void saveData(Question o) {
        question = loadData();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(QUIZFILELOCATION))) {
            
            question.add(o);
            oos.writeObject(question);
            oos.close();

        } catch (IOException ex) {
            Logger.getLogger(IOAnimals.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Question> loadData() {
        
        if(!file.exists()){
                question = new ArrayList<>();
            
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(QUIZFILELOCATION))) {
            System.out.println("cat");
            question.addAll((ArrayList<Question>) ois.readObject());
            System.out.println("dog");
        } catch (Exception ex) {
            Logger.getLogger(IOAnimals.class.getName()).log(Level.SEVERE, null, ex);
        }

        return question;
    }

    public int size() {
        return question.size();
    }
    
}