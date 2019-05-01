/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creaturecapture;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PlayerTest {
    
    public PlayerTest() {
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
    }

    /**
     * Test of CheckEnergy method, of class Player.
     */
    @Test
    public void testCheckEnergy() {
        System.out.println("CheckEnergy");
        Player instance = new Player(100);
        int expResult = 100;
        int result = instance.CheckEnergy();
        assertEquals(expResult, result);

    }

    /**
     * Test of SubtractEnergy method, of class Player.
     */
    @Test
    public void testSubtractEnergy() {
        System.out.println("SubtractEnergy");
        int EnergySubtraction = 50;
        Player instance = new Player(100);
        instance.SubtractEnergy(EnergySubtraction);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of AddEnergy method, of class Player.
     */
    @Test
    public void testAddEnergy() {
        System.out.println("AddEnergy");
        int EnergyAdded = 0;
        Player instance = null;
        instance.AddEnergy(EnergyAdded);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of WebCast method, of class Player.
     */
    @Test
    public void testWebCast() {
        System.out.println("WebCast");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.WebCast();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ForceBubble method, of class Player.
     */
    @Test
    public void testForceBubble() {
        System.out.println("ForceBubble");
        Player instance = null;
        boolean expResult = false;
        boolean result = instance.ForceBubble();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of FreezeRay method, of class Player.
     */
    @Test
    public void testFreezeRay() {
        System.out.println("FreezeRay");
        int UserEnergyInput = 0;
        int ChkSpeed = 0;
        int ChkStrength = 0;
        Player instance = null;
        int expResult = 0;
        int result = instance.FreezeRay(UserEnergyInput, ChkSpeed, ChkStrength);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
