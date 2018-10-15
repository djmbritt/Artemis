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
import com.sbnvw.artemis.managers.AnimalManager;
import com.sbnvw.artemis.managers.TraitsManager;
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

    Kingdom Animal = new Kingdom("Animal");
    Phylum Chordata = new Phylum("Chordata", Animal);
    ClassType Mammalia = new ClassType("Mammalia", Chordata);
    Order Carnivora = new Order("Carnivora", Mammalia);
    Family Felidae = new Family("Felidae", Carnivora);
    Genus felis = new Genus("Felis", Felidae);
    Species cat = new Species("Cat", felis);

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
    public void testGetTraitFromAnimal() {
        AnimalFactory.makeAnimal("Korthaar", this.cat);
        TraitGroup diet = new TraitGroup("Diet");
        diet.addTraitBehaviour(new TraitBehaviour("Eats meat", diet));
        this.Carnivora.addTrait(diet.getTraitBehaviours().get(0));
        TraitBehaviour tb = (TraitBehaviour) AnimalManager.getAnimals().get(0).getTraits().get(0);
        assertEquals("Eats meat", tb.getBehaviour());

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
