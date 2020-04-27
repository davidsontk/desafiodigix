package com.digix.desafio.dto;

import com.digix.desafio.model.Renda;

/**
 *
 * @author david
 */
public class RendaDTO {

    private Integer pessoaId;
    private int renda;

    public RendaDTO(Renda renda) {
        this.pessoaId = renda.getPessoaId().getId();
        this.renda = renda.getRenda();
    }

    public Integer getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public int getRenda() {
        return renda;
    }

    public void setRenda(int renda) {
        this.renda = renda;
    }

}
