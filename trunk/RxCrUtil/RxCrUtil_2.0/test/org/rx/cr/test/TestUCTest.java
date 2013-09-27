/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rx.cr.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hp
 */
public class TestUCTest {
    
    public TestUCTest() {
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
     * Test of _cargarCombos method, of class TestUC.
     */
    @Test
    public void test_cargarCombos() {
        System.out.println("_cargarCombos");
        TestUC instance = new TestUC();
        instance._cargarCombos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _agregaValidadoresControl method, of class TestUC.
     */
    @Test
    public void test_agregaValidadoresControl() {
        System.out.println("_agregaValidadoresControl");
        TestUC instance = new TestUC();
        instance._agregaValidadoresControl();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _isDatosValidosBE method, of class TestUC.
     */
    @Test
    public void test_isDatosValidosBE() {
        System.out.println("_isDatosValidosBE");
        TestUC instance = new TestUC();
        boolean expResult = false;
        boolean result = instance._isDatosValidosBE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _registrarBE method, of class TestUC.
     */
    @Test
    public void test_registrarBE() throws Exception {
        System.out.println("_registrarBE");
        TestUC instance = new TestUC();
        int expResult = 0;
        int result = instance._registrarBE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _guardarCambiosBE method, of class TestUC.
     */
    @Test
    public void test_guardarCambiosBE() throws Exception {
        System.out.println("_guardarCambiosBE");
        TestUC instance = new TestUC();
        int expResult = 0;
        int result = instance._guardarCambiosBE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _listarBEs method, of class TestUC.
     */
    @Test
    public void test_listarBEs() throws Exception {
        System.out.println("_listarBEs");
        TestUC instance = new TestUC();
        instance._listarBEs();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _recuperarDatosBE method, of class TestUC.
     */
    @Test
    public void test_recuperarDatosBE() {
        System.out.println("_recuperarDatosBE");
        TestUC instance = new TestUC();
        instance._recuperarDatosBE();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _deshabilitarControlesDatos method, of class TestUC.
     */
    @Test
    public void test_deshabilitarControlesDatos() {
        System.out.println("_deshabilitarControlesDatos");
        TestUC instance = new TestUC();
        instance._deshabilitarControlesDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _habilitarControlesDatos method, of class TestUC.
     */
    @Test
    public void test_habilitarControlesDatos() {
        System.out.println("_habilitarControlesDatos");
        TestUC instance = new TestUC();
        instance._habilitarControlesDatos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of _resetControls method, of class TestUC.
     */
    @Test
    public void test_resetControls() {
        System.out.println("_resetControls");
        TestUC instance = new TestUC();
        instance._resetControls();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TestUC.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TestUC.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}