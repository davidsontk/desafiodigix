package com.digix.desafio.dto;

import com.digix.desafio.model.Familia;
import com.digix.desafio.model.Renda;
import java.util.List;

/**
 *
 * @author david
 */
public class FamiliaDTO {

    private String id;
    private Integer status;
    private List<PessoaDTO> pessoas;
    private List<RendaDTO> rendas;
    private int pontos;
    
    public FamiliaDTO(Familia familia) {
        this.id = familia.getId();
        this.status = familia.getStatusId().getId();
    }

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

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public List<RendaDTO> getRendas() {
        return rendas;
    }

    public void setRendas(List<RendaDTO> rendas) {
        this.rendas = rendas;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
    
}
