package com.sbnvw.artemis;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.ClassType;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Family;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Genus;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Kingdom;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Order;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Phylum;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.AnimalFactory;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.ClassificationFactory;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class Setup {

    public Setup() throws ClassNotFoundException {

        setupClassifications();

    }

    private void setupClassifications() throws ClassNotFoundException {

        Kingdom Animal = (Kingdom) ClassificationFactory.makeClassification("Animal", null, "Kingdom");
        Phylum Chordata = (Phylum) ClassificationFactory.makeClassification("Chordata", Animal, "Phylum");
        ClassType Mammalia = (ClassType) ClassificationFactory.makeClassification("Mammalia", Chordata, "ClassType");
        Order Carnivora = (Order) ClassificationFactory.makeClassification("Carnivora", Mammalia, "Order");
        Family Felidae = (Family) ClassificationFactory.makeClassification("Felidae", Carnivora, "Family");
        Genus felis = (Genus) ClassificationFactory.makeClassification("Felis", Felidae, "Genus");
        Species cat = (Species) ClassificationFactory.makeClassification("Cat", felis, "Species");
        Animal korthaar = AnimalFactory.makeAnimal("Korthaar", cat);

    }

}
