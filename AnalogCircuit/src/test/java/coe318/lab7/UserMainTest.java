/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package coe318.lab7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author zjell
 */
public class UserMainTest {
    
    public UserMainTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addResistor method, of class UserMain.
     */
    @Test
    public void testAddResistor() {
        System.out.println("addResistor");
        resistors res = new resistors(1, 1, 2, 4);
        UserMain instance = new UserMain();
        instance.addResistor(res);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addPolarized method, of class UserMain.
     */
    @Test
    public void testAddPolarized() {
        System.out.println("addPolarized");
        polarized d = new polarized(1, 0, 1, 3);
        UserMain instance = new UserMain();
        instance.addPolarized(d);
        // TODO review the generated test code and remove the default call to fail.
    }

    
    
}
