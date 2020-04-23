package com.digix.desafio.controller;

import com.digix.desafio.StarterApplication;
import com.digix.desafio.dto.TipoDTO;
import com.digix.desafio.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
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
    
    @PostMapping
    public HttpStatus salvarTipo(@RequestBody TipoDTO tipoDTO){
        try {
            
            if(tipoDTO.getId().equals("")){
                return HttpStatus.BAD_REQUEST;
            }
          //tipoRepository.save(this)
          
                            
            return HttpStatus.OK;
            
        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.OK;
        }
    }
    
}
