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
    private List<Renda> rendas;

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

    public List<Renda> getRendas() {
        return rendas;
    }

    public void setRendas(List<Renda> rendas) {
        this.rendas = rendas;
    }

}
