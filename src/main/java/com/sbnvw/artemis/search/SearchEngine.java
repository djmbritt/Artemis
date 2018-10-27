package com.sbnvw.artemis.search;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class SearchEngine {

    public List<Animal> getFilterdList(String textFilter, List<Animal> animals) {
        List<Animal> filterdList = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            Animal a = animals.get(i);
            if (a.toString().toLowerCase().contains(textFilter.toLowerCase())) {
                filterdList.add(a);
            }
        }

        return filterdList;
    }

}
