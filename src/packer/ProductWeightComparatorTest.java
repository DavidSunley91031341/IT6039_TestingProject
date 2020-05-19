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
public class ProductWeightComparatorTest {
  
  public ProductWeightComparatorTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
    System.out.println("Testing ProductWeightComparator class...");
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
   * Test of compare method, of class ProductWeightComparator.
   */
  @Test
  public void testCompare() {
      System.out.println("compare");
      Product a = new Product("Guitar", 10, true, false);
      Product b = new Product("Guitar", 10, true, false);
      ProductWeightComparator instance = new ProductWeightComparator();
      int expResult = 0;
      int result = instance.compare(a, b);
      assertEquals(expResult, result);
        
    }
  
}
