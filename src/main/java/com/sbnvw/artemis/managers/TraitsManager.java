package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class TraitsManager {

    private static final List<TraitGroup> TRAIT_GROUPS = new ArrayList<>();

    public static void addTraitGroup(TraitGroup traitGroup) {
        TRAIT_GROUPS.add(traitGroup);

    }

    public static List<TraitGroup> getTRAIT_GROUPS() {
        return TRAIT_GROUPS;
    }

}
