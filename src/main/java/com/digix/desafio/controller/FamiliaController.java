package com.digix.desafio.controller;

import com.digix.desafio.StarterApplication;
import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.service.CRUDService;
import com.digix.desafio.service.FamiliaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;
    
    @Autowired
    private CRUDService crudService;

    @GetMapping("/buscarFamiliasAptas")
    public List<FamiliaDTO> buscarFamiliasAptas() {

        return familiaService.buscarFamiliasAptas();
    }

    @GetMapping("/buscarFamiliasContempladas/{pagina}/{tamanhoPagina}")
    public ResponseEntity<Page> buscarFamiliasContempladas(@PathVariable int pagina, @PathVariable int tamanhoPagina) {
        
        return familiaService.buscarFamiliasContempladas(pagina, tamanhoPagina);
    }
    
    @GetMapping("/gerarDadosFake")
    public HttpStatus gerarDadosFake(){
        return crudService.gerarDadosFake();
    }
    
}
