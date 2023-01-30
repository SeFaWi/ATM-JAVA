/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.mavenproject1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sefaw
 */
public class AccountTest {
    
    public AccountTest() {
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
     * Test of getamount method, of class Account.
     */
    @Test
    public void testGetamount() {
        System.out.println("getamount");
        String id = "";
        Account instance = new Account();
        String expResult = "";
        String result = instance.getamount(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkamount method, of class Account.
     */
    @Test
    public void testCheckamount() {
        System.out.println("checkamount");
        String id = "";
        int value = 0;
        Account instance = new Account();
        String expResult = "";
        String result = instance.checkamount(id, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of amount method, of class Account.
     */
    @Test
    public void testAmount() {
        System.out.println("amount");
        String id = "";
        int value = 0;
        Account instance = new Account();
        String expResult = "";
        String result = instance.amount(id, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of withamount method, of class Account.
     */
    @Test
    public void testWithamount() {
        System.out.println("withamount");
        String id = "";
        Float amount = null;
        Account instance = new Account();
        instance.withamount(id, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
