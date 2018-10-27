package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.managers.AnimalManager;
import com.sbnvw.artemis.search.SearchEngine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class SearchController {

    private SearchEngine searchEngine;
    private MainSearchWindowController viewController;
    private List<Animal> animals;

    public SearchController() {

        this.searchEngine = new SearchEngine();
        this.viewController = MainSearchWindowController.getSelf();

    }

    public List<Animal> searchForAnimals(String textFilter) {
        this.animals = AnimalManager.getAnimals();
        return searchEngine.getFilterdList(textFilter, animals);

    }

}
