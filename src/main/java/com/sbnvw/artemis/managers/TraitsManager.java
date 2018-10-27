package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.animal_kingdom.traits.TraitBehaviour;
import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.Factory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class TraitsManager {

    private static final List<TraitGroup> TRAIT_GROUPS = new ArrayList<>();
    private static final FactoryManager factoryManager = new FactoryManager();

    public static TraitGroup addTraitGroup(TraitGroup traitGroup) {
        TRAIT_GROUPS.add(traitGroup);
        factoryManager.alert();
        return traitGroup;

    }

    public static List<TraitGroup> getTRAIT_GROUPS() {
        return TRAIT_GROUPS;
    }

    public static TraitBehaviour getTraitBehaviourByName(String name) throws ClassNotFoundException {
        TraitBehaviour tb = null;

        for (int i = 0; i < TRAIT_GROUPS.size(); i++) {
            List<TraitBehaviour> tbs = TRAIT_GROUPS.get(i).getTraitBehaviours();
            for (int j = 0; j < tbs.size(); j++) {
                if (name.equalsIgnoreCase(tbs.get(j).getBehaviour())) {
                    tb = tbs.get(j);
                }
            }

        }

        if (tb == null) {
            throw new ClassNotFoundException(name + " does not exists");
        }

        return tb;
    }

    public static Object getTraitGroupFromName(String name) throws ClassNotFoundException {
        List<TraitGroup> c = TraitsManager.TRAIT_GROUPS;
        Object o = null;
        for (int i = 0; i < c.size(); i++) {
            if (name.equals(c.get(i).getName())) {
                o = c.get(i);
            }
        }

        if (o == null) {
            throw new ClassNotFoundException(name + " does not exists");
        }

        return o;
    }

}
