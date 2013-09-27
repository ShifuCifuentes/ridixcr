/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rx.cr.test;

import java.util.ArrayList;
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
public class DAOTestTest {
    
    public DAOTestTest() {
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
     * Test of registrar method, of class DAOTest.
     */
    @Test
    public void testRegistrar() {
        System.out.println("registrar");
        Object obj = null;
        DAOTest instance = null;
        int expResult = 0;
        int result = instance.registrar(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizarRegistro method, of class DAOTest.
     */
    @Test
    public void testActualizarRegistro() {
        System.out.println("actualizarRegistro");
        Object obj = null;
        DAOTest instance = null;
        int expResult = 0;
        int result = instance.actualizarRegistro(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarRegistro method, of class DAOTest.
     */
    @Test
    public void testEliminarRegistro() {
        System.out.println("eliminarRegistro");
        Object obj = null;
        DAOTest instance = null;
        int expResult = 0;
        int result = instance.eliminarRegistro(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarReferencia method, of class DAOTest.
     */
    @Test
    public void testBuscarReferencia() {
        System.out.println("buscarReferencia");
        String referencia = "";
        DAOTest instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.buscarReferencia(referencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listar method, of class DAOTest.
     */
    @Test
    public void testListar() {
        System.out.println("listar");
        DAOTest instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.listar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class DAOTest.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int id = 0;
        DAOTest instance = null;
        Object expResult = null;
        Object result = instance.buscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of autenticarUsuario method, of class DAOTest.
     */
    @Test
    public void testAutenticarUsuario() {
        System.out.println("autenticarUsuario");
        String user = "";
        String password = "";
        DAOTest instance = null;
        Object expResult = null;
        Object result = instance.autenticarUsuario(user, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}