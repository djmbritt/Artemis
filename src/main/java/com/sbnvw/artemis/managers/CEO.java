package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import com.sbnvw.artemis.io.IOCEO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class CEO implements Observer {

    private FactoryManager f = new FactoryManager();
    private List<ArrayList> dictionary = new ArrayList<>();
    private IOCEO loader = new IOCEO();

    public CEO() {
        init();

    }

    private void init() {
        f.attach(this);
    }

    @Override
    public void update() {
        dictionary.clear();
        dictionary.add((ArrayList) ClassificationManager.getClassifications());
        dictionary.add(TraitsManager.getTraitsStore());
        dictionary.add(AnimalManager.getAnimals());
        loader.saveData(dictionary);

    }

    public void setup() {
        dictionary = loader.loadData();

        for (int i = 0; i < dictionary.size(); i++) {
            if (!dictionary.get(i).isEmpty()) {
                if (dictionary.get(i).get(0) instanceof Animal) {
                    AnimalManager.setAnimals(dictionary.get(i));
                } else if (dictionary.get(i).get(0) instanceof ArrayList) {
                    TraitsManager.setTraitsStoreAndUpdate(dictionary.get(i));
                } else if (dictionary.get(i).get(0) instanceof Classification) {
                    ClassificationManager.setClassifications(dictionary.get(i));
                }
            }

        }

    }

    public List<ArrayList> getDictionary() {
        return dictionary;
    }

}
