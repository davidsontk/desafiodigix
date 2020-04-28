/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digix.desafio.controller;

import com.digix.desafio.dto.FamiliaDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author david
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FamiliaControllerTest {
    
    @Autowired
    private FamiliaController familiaController;
    
    public FamiliaControllerTest() {
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of buscarFamiliasAptas method, of class FamiliaController.
     */
    @Test
    public void testBuscarFamiliasAptas() {
        System.out.println("buscarFamiliasAptas");
        HttpStatus status = familiaController.gerarDadosFake();
        
        assertEquals(HttpStatus.OK, status);
        List<FamiliaDTO> result = familiaController.buscarFamiliasAptas();
        
        assertNotNull(result);
    }

    
    
    /**
     * Test of buscarFamiliasContempladas method, of class FamiliaController.
     */
    @Test
    public void testBuscarFamiliasContempladas() {
        System.out.println("buscarFamiliasContempladas");
        int pagina = 0;
        int tamanhoPagina = 1;
        
        ResponseEntity<Page> result = familiaController.buscarFamiliasContempladas(pagina, tamanhoPagina);
        
        assertNotNull(result);

    }

    /**
     * Test of gerarDadosFake method, of class FamiliaController.
     */
    @Test
    public void testGerarDadosFake() {
        System.out.println("gerarDadosFake");
        HttpStatus expResult = HttpStatus.OK;
        HttpStatus result = familiaController.gerarDadosFake();
        
        assertEquals(expResult, result);
        
//        fail("The test case is a prototype.");
    }
    
}
