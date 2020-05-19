/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packer;

import java.util.List;
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
public class PackerTest {
  
  public PackerTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println("Testing Packer class...");
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

//  /**
//   * Test of packProducts method, of class Packer.
//   */
//  @Test
//  public void testPackProducts() {
//    System.out.println("packProducts");
//    Customer customer = null;
//    Depot depot = null;
//    Manifest manifest = null;
//    List<Box> expResult = null;
//    List<Box> result = null;
//    assertEquals(expResult, result);
//    }
  
  Product Apple = new Product("Apple", 3, true, true);
  Product Mandarin = new Product("Mandarin", 2, true, true);
  Product Banana = new Product("Banana", 4, true, true);
  
  Coordinates coord1 = new Coordinates(0, 0);
  Coordinates coord2 = new Coordinates(55, 55);
  
  Address address1 = new Address("Hi", "How", "Are You", "H647", coord1);
  Address address2 = new Address("Hello", "I'm", "Good Thanks", "F536", coord2);
  
  Customer c = new Customer("Customer", address1);
  Depot d = new Depot("Depot", address2);
  
  Manifest m = new Manifest();
  
    /**
   * Test of packProducts method, of class Packer.
   */
  @Test
  public void testPackProducts() {
    System.out.println("packProducts");
    m.addProduct(Apple, 1);
    m.addProduct(Mandarin, 2);
    m.addProduct(Banana, 3);
    List<Box> packedBoxes = Packer.packProducts(c, d, m);
    assertEquals(1, packedBoxes.size());
    }
  
}
