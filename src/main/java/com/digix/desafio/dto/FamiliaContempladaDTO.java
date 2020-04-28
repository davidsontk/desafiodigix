package com.digix.desafio.dto;

import java.util.Date;

/**
 *
 * @author davidson ferreira
 */
public class FamiliaContempladaDTO {
    
    private Integer familiaId;
    private int quantidadeCriteriosAtendidos;
    private int pontuacaoTotal;
    private Date dataDeContemplacao; 
    
    public Integer getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(Integer familiaId) {
        this.familiaId = familiaId;
    }

    public int getQuantidadeCriteriosAtendidos() {
        return quantidadeCriteriosAtendidos;
    }

    public void setQuantidadeCriteriosAtendidos(int quantidadeCriteriosAtendidos) {
        this.quantidadeCriteriosAtendidos = quantidadeCriteriosAtendidos;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(int pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public Date getDataDeContemplacao() {
        return dataDeContemplacao;
    }

    public void setDataDeContemplacao(Date dataDeContemplacao) {
        this.dataDeContemplacao = dataDeContemplacao;
    }
    
}
