package com.digix.desafio.controller;

import com.digix.desafio.dto.TipoDTO;
import com.digix.desafio.model.Tipo;
import com.digix.desafio.repository.TipoRepository;
import com.digix.desafio.service.FamiliaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/tipo")
public class TipoController {

    @Autowired
    private TipoRepository tipoRepository;
    
    @Autowired
    private FamiliaService familiaService;

    @PostMapping
    public HttpStatus salvarTipo(@RequestBody TipoDTO tipoDTO) {
        try {
            if (tipoDTO.getId().equals("")) {
                return HttpStatus.BAD_REQUEST;
            }
            Tipo tipo = new Tipo();
            tipo.setDescricao(tipoDTO.getDescricao());
            tipo.setId(tipoDTO.getId());
//            tipoRepository.save(tipo);
            return HttpStatus.OK;

        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.OK;
        }
    }

    @GetMapping
    public List<Tipo> buscarTodosTipos() {
        try {
            return tipoRepository.findAll();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
