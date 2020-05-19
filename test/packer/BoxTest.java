package packer;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author David
 */

public class BoxTest {

    Customer testCustomerA = new Customer("Phillip", new Address("King Street", "CBD", "Auckland","1070", new Coordinates(50, 60)));
    Customer testCustomerB = new Customer("Michael", new Address("Salamander Street", "Brighton", "Christchurch", "3030", new Coordinates(3000, 3040)));

    Depot testDepotA = new Depot("testDepot0", new Address("Queen Street", "CBD", "Auckland", "1010", new Coordinates(1010, 2020)));
    Depot testDepotB = new Depot("testDepot1", new Address("Franktown Street", "Bristol", "Auckland", "1070", new Coordinates(1000, 2000)));

    Product testProductA = new Product("Record Player", 10, false, true);
    Product testProductB = new Product("Potting Plant Mix", 100, true, false);

    Box testBoxA = new Box(testCustomerA, testDepotA);
    Box testBoxB = new Box(testCustomerB, testDepotB);

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Testing Box class...");
    }

    /**
     * Test of getLabel method, of class Box
     */
    @Test
    public void testGetLabel() {
        System.out.println("getLabel");
        testBoxB.addProduct(testProductB, 3);
        assertEquals("Michael\nSalamander Street\nBrighton\nChristchurch\n3030\nPotting Plant Mix x 3\n", testBoxB.getLabel());
    }

    /**
     * Test of toString method, of class Box
     */
    @Test
    public void testToString() {
        testBoxA.addProduct(testProductA, 5);
        testBoxB.addProduct(testProductB, 3);

        System.out.println("toString");
        assertEquals("Phillip\nKing Street\nCBD\nAuckland\n1070\nRecord Player x 5\nFRAGILE\n",
                testBoxA.toString());
        assertEquals("Michael\nSalamander Street\nBrighton\nChristchurch\n3030\nPotting Plant Mix x 3\n",
                testBoxB.toString());
    }
    
    /**
     * Test of getWeight method, of class Box
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        testBoxA.addProduct(testProductB, 10);
        testBoxA.addProduct(testProductA, 5);
        assertEquals(1000, testBoxA.getWeight(), 0.0001);
    }
    
    /**
     * Test of canFit method, of class Box
     */
    @Test
    public void testCanFit() {
        System.out.println("canFit");
        Assert.assertFalse(testBoxA.canFit(testProductB));
        Assert.assertFalse(testBoxA.canFit(testProductA, 11));
    }
    
    /**
     * Test of remainingCapacity method, of class Box
     */
    @Test
    public void testRemainingCapacity() {
        System.out.println("remainingCapacity");
        testBoxA.addProduct(testProductA, 1);
        assertEquals(24, testBoxA.remainingCapacity(), 24);
    }
    
    /**
     * Test of isFragile method, of class Box
     */
    @Test
    public void testIsFragile() {
        System.out.println("isFragile");
        testBoxB.addProduct(testProductA);
        testBoxB.addProduct(testProductB);
        assertTrue(testBoxB.isFragile());
    }


}