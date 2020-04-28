package com.digix.desafio.controller;

import com.digix.desafio.StarterApplication;
import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.service.FamiliaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public List<FamiliaDTO> buscarFamiliasAptas() {
        
        return familiaService.buscarFamiliasAptas();
    }
}
