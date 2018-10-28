package com.sbnvw.artemis.managers;

import com.sbnvw.artemis.animal_kingdom.traits.TraitBehaviour;
import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.Factory;
import com.sbnvw.artemis.io.IOTraits;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class TraitsManager {

    private static ArrayList<TraitGroup> TRAIT_GROUPS = new ArrayList<>();
    private static ArrayList<TraitBehaviour> behaviours = new ArrayList<>();
    private static final FactoryManager factoryManager = new FactoryManager();
    private static ArrayList<ArrayList> traitsStore = new ArrayList<>();
    private static final IOTraits loader = new IOTraits();

    public static TraitGroup addTraitGroup(TraitGroup traitGroup) {
        TRAIT_GROUPS.add(traitGroup);
        updateBehaveiors();
        factoryManager.alert();
        save();
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

    public static void load() {
        TRAIT_GROUPS = loader.loadData();

    }

    public static void save() {

        loader.saveData(TRAIT_GROUPS);
    }

    public static void setTRAIT_GROUPS(ArrayList<TraitGroup> TRAIT_GROUPS) {
        TraitsManager.TRAIT_GROUPS = TRAIT_GROUPS;
    }

    public static void updateBehaveiors() {

        behaviours.clear();
        traitsStore.clear();

        for (int i = 0; i < TRAIT_GROUPS.size(); i++) {
            TraitGroup t = TRAIT_GROUPS.get(i);
            for (int j = 0; j < t.getTraitBehaviours().size(); j++) {
                behaviours.add(t.getTraitBehaviours().get(j));
            }
        }

        traitsStore.add((ArrayList) TRAIT_GROUPS);
        traitsStore.add((ArrayList) behaviours);
        factoryManager.alert();
    }

    public static ArrayList<ArrayList> getTraitsStore() {
        return traitsStore;
    }

    public static void setTraitsStoreAndUpdate(List<ArrayList> traitsStore) {
        TraitsManager.traitsStore = (ArrayList<ArrayList>) traitsStore;
        TRAIT_GROUPS = traitsStore.get(0);
        behaviours = traitsStore.get(1);

    }

}
