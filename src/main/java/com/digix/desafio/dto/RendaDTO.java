package com.digix.desafio.dto;

import com.digix.desafio.model.Renda;

/**
 *
 * @author david
 */
public class RendaDTO {

    private String pessoaId;
    private int renda;

    public RendaDTO(Renda renda) {
        this.pessoaId = renda.getPessoaId().getId();
        this.renda = renda.getRenda();
    }

    public String getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(String pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getRenda() {
        return renda;
    }

    public void setRenda(int renda) {
        this.renda = renda;
    }

}
