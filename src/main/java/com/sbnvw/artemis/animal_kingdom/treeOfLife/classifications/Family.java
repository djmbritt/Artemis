package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Family extends Classification{

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

}
