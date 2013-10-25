/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sysconpat.rx.bl;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sysconpat.rx.be.BEArea;

/**
 *
 * @author ridix
 */
public class BLAreaTest {
    
    public BLAreaTest() {
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
     * Test of registrar method, of class BLArea.
     */
    @Test
    public void testRegistrar() throws Exception {
        System.out.println("registrar");
        BEArea bean = null;
        BLArea instance = new BLArea();
        int expResult = 0;
        int result = instance.registrar(bean);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarRegistro method, of class BLArea.
     */
    @Test
    public void testActualizarRegistro() throws Exception {
        System.out.println("actualizarRegistro");
        BEArea bean = null;
        BLArea instance = new BLArea();
        int expResult = 0;
        int result = instance.actualizarRegistro(bean);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarRegistro method, of class BLArea.
     */
    @Test
    public void testEliminarRegistro() throws Exception {
        System.out.println("eliminarRegistro");
        BEArea bean = null;
        BLArea instance = new BLArea();
        int expResult = 0;
        int result = instance.eliminarRegistro(bean);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarReferencia method, of class BLArea.
     */
    @Test
    public void testBuscarReferencia_String() throws Exception {
        System.out.println("buscarReferencia");
        String referencia = "";
        BLArea instance = new BLArea();
        ArrayList expResult = null;
        ArrayList result = instance.buscarReferencia(referencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarReferencia method, of class BLArea.
     */
    @Test
    public void testBuscarReferencia_int() throws Exception {
        System.out.println("buscarReferencia");
        int id = 0;
        BLArea instance = new BLArea();
        ArrayList expResult = null;
        ArrayList result = instance.buscarReferencia(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class BLArea.
     */
    @Test
    public void testListar() throws Exception {
        System.out.println("listar");
        BLArea instance = new BLArea();
        ArrayList expResult = null;
        ArrayList result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class BLArea.
     */
    @Test
    public void testBuscar() throws Exception {
        System.out.println("buscar");
        int id = 0;
        BLArea instance = new BLArea();
        BEArea expResult = null;
        BEArea result = instance.buscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}