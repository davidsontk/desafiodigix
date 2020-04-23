
package com.digix.desafio.controller;

import com.digix.desafio.dto.TipoDTO;
import java.util.UUID;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author david
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TipoControllerTest {

    public TipoControllerTest() {

    }

    @Autowired
    TipoController tipoController;


    /**
     * Test of salvarTipo method, of class TipoController.
     */
    @Test
    public void testSalvarTipo() {
        System.out.println("salvarTipo");
        
        
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();

        System.out.println("Random UUID String = " + randomUUIDString);
        
        TipoDTO tipoDTO = new TipoDTO();
        tipoDTO.setId(randomUUIDString);
        System.out.println("Random UUID String = " + randomUUIDString);
        //TipoController instance = new TipoController();
        HttpStatus result = tipoController.salvarTipo(tipoDTO);
        
        assertEquals(HttpStatus.OK, result.OK);
        // TODO review the generated test code and remove the default call to fail.
        
    }

}
