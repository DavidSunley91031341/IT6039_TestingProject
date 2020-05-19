/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class ManifestTest {
  
  public ManifestTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println("Testing Manifest class...");
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of addProduct method, of class Manifest.
   */
  @Test
  public void testAddProduct_Product() {
        System.out.println("addProduct");
        Product product = new Product("Mandarin", 2, false, false);
        Manifest instance = new Manifest();
        instance.addProduct(product);
        assertEquals(true, instance.containsProduct(product));
    }

    /**
     * Test of addProduct method, of class Manifest.
     */
    @Test
    public void testAddProduct_Product_int() {
        System.out.println("addProduct");
        Product product = new Product("Apple", 3, true, false);
        int quantity = 2;
        int expresult = 2;
        Manifest instance = new Manifest();
        instance.addProduct(product, quantity);
        assertEquals(expresult, quantity);
    }

    /**
     * Test of removeProduct method, of class Manifest.
     */
    @Test
    public void testRemoveProduct() {
        System.out.println("Testing removeProduct");
        Product apple = new Product("Apple", 3, true, false);
        Manifest instance = new Manifest();
        instance.addProduct(apple);
        instance.removeProduct(apple);
        assertEquals(true, instance.isEmpty());
    }

    /**
     * Test of getTotalWeight method, of class Manifest.
     */
    @Test
    public void testGetTotalWeight() {
        System.out.println("getTotalWeight");
        Product apple = new Product("Apple", 3, true, false);
        Manifest instance = new Manifest();
        instance.addProduct(apple);
        double expResult = 3.0;
        double result = instance.getTotalWeight();
        assertEquals(expResult, result, 3.0);
    }

    /**
     * Test of getHeaviestUnder method, of class Manifest.
     */
    @Test
    public void testGetHeaviestUnder() {
        System.out.println("getHeaviestUnder");
        double weight = 0.0;
        Manifest instance = new Manifest();
        Product expResult = null;
        Product result = instance.getHeaviestUnder(weight);
        assertEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class Manifest.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        Product apple = new Product("Apple", 3, true, false);
        Manifest instance = new Manifest();
        instance.addProduct(apple);
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

    /**
     * Test of containsProduct method, of class Manifest.
     */
    @Test
    public void testContainsProduct() {
        System.out.println("containsProduct");
        Product mandarin = new Product("Mandarin", 2, false, false);
        Manifest instance = new Manifest();
        instance.addProduct(mandarin);
        boolean expResult = true;
        boolean result = instance.containsProduct(mandarin);
        assertEquals(expResult, result);
    }


    /**
     * Test of hasFragileItems method, of class Manifest.
     */
    @Test
    public void testHasFragileItems() {
        System.out.println("hasFragileItems");
        Product glass = new Product("Glass", 1, true, true);
        Manifest instance = new Manifest();
        instance.addProduct(glass);
        boolean expResult = true;
        boolean result = instance.hasFragileItems();
        assertEquals(expResult, result);
    }
  
}
