package com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Order extends Classification{

    private ClassType classType;

    public Order(String name, ClassType classType) {
        super(name);
        this.classType = classType;
    }

    public ClassType getClassType() {
        return classType;
    }

    @Override
    public String getName() {
        return super.getName();
    }

}
