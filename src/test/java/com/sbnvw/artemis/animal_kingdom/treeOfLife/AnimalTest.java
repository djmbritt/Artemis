package com.sbnvw.artemis.animal_kingdom.treeOfLife;

import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import com.sbnvw.artemis.animal_kingdom.traits.TraitBehaviour;
import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.ClassType;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Family;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Genus;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Kingdom;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Order;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Phylum;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Species;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.AnimalFactory;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.factorys.ClassificationFactory;
import com.sbnvw.artemis.managers.AnimalManager;
import com.sbnvw.artemis.managers.ClassificationManager;
import com.sbnvw.artemis.managers.TraitsManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class AnimalTest {

    Kingdom Animal;
    Phylum Chordata;
    ClassType Mammalia;
    Order Carnivora;
    Family Felidae;
    Genus felis;
    Species cat;
    Animal korthaar;

    public AnimalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        try {
            Animal = (Kingdom) ClassificationFactory.makeClassification("Animal", null, "Kingdom");
            Chordata = (Phylum) ClassificationFactory.makeClassification("Chordata", Animal, "Phylum");
            Mammalia = (ClassType) ClassificationFactory.makeClassification("Mammalia", Chordata, "ClassType");
            Carnivora = (Order) ClassificationFactory.makeClassification("Carnivora", Mammalia, "Order");
            Felidae = (Family) ClassificationFactory.makeClassification("Felidae", Carnivora, "Family");
            felis = (Genus) ClassificationFactory.makeClassification("Felis", Felidae, "Genus");
            cat = (Species) ClassificationFactory.makeClassification("Cat", felis, "Species");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AnimalTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AnimalTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @After
    public void tearDown() {
        AnimalManager.clearList();
    }

    @Test
    public void testMakeAnimal() {
        AnimalFactory.makeAnimal("Korthaar", this.cat);
        assertEquals("Korthaar", AnimalManager.getAnimals().get(0).getName());

    }

    @Test
    public void testMakeTrait() {
        AnimalFactory.makeAnimal("Korthaar", this.cat);
        TraitGroup diet = new TraitGroup("Diet");
        diet.addTraitBehaviour(new TraitBehaviour("Eats meat", diet));
        TraitGroup tr = TraitsManager.getTRAIT_GROUPS().get(0);
        TraitBehaviour tb = tr.getTraitBehaviours().get(0);
        assertEquals("Eats meat", tb.getBehaviour());

    }

    @Test
    public void testGetTraitFromAnimal() throws ClassNotFoundException {
        Animal c = AnimalFactory.makeAnimal("Korthaar", this.cat);
        TraitGroup diet = new TraitGroup("Diet");
        diet.addTraitBehaviour(new TraitBehaviour("Eats meat", diet));
        ClassificationManager.getClassificationByName("Carnivora").addTrait(diet);
        List<TraitGroup> l = c.getSpecies().getTraits();
        TraitBehaviour tg = l.get(0).getTraitBehaviours().get(0);
        String tb = tg.getBehaviour();
        assertEquals("Eats meat", tb);

    }

    @Test
    public void testGetAnimals() {
        AnimalFactory.makeAnimal("Korthaar", this.cat);
        AnimalFactory.makeAnimal("Swinx", this.cat);
        AnimalFactory.makeAnimal("Boskat", this.cat);
        AnimalFactory.makeAnimal("Petz", this.cat);

        assertEquals(4, AnimalManager.getSize());

    }

}
