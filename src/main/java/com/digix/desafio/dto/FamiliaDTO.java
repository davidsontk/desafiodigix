package com.digix.desafio.dto;

import com.digix.desafio.model.Pessoa;
import com.digix.desafio.model.Renda;
import java.util.List;

/**
 *
 * @author david
 */
public class FamiliaDTO {

    private String id;
    private Integer status;
    private List<Pessoa> pessoas;
    private List<Renda> rendas;
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Renda> getRendas() {
        return rendas;
    }

    public void setRendas(List<Renda> rendas) {
        this.rendas = rendas;
    }
    
    
    
}
