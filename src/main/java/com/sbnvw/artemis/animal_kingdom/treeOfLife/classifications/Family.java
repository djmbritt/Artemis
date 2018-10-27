package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Family extends Classification {

    private Order order;

    public Family(String name, Order order) {
        super(name);
        this.order = order;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public List<Trait> getTraits() {
        List trList = new ArrayList();
        List myTraits = getOrder().getTraits();
        for (int i = 0; i < traits.size(); i++) {
            trList.add(traits.get(i));
        }
        for (int i = 0; i < myTraits.size(); i++) {
            trList.add(myTraits.get(i));
        }

        return trList;
    }

}
