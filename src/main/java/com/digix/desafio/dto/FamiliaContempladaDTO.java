package com.digix.desafio.dto;

import com.digix.desafio.model.FamiliaContemplada;
import com.digix.desafio.utils.UtilitariosHelper;
import java.util.Date;

/**
 *
 * @author davidson ferreira
 */
public class FamiliaContempladaDTO {

    private Integer familiaId;
    private int quantidadeCriteriosAtendidos;
    private int pontuacaoTotal;
    private String dataDeContemplacao;

    public FamiliaContempladaDTO(FamiliaContemplada fc) {
        this.familiaId = fc.getId();
        this.quantidadeCriteriosAtendidos = fc.getCriterioAtendido();
        this.pontuacaoTotal = fc.getPontuacaoTotal();
        this.dataDeContemplacao = UtilitariosHelper.formatarData(fc.getDataContemplacao());
    }

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

    public String getDataDeContemplacao() {
        return dataDeContemplacao;
    }

    public void setDataDeContemplacao(String dataDeContemplacao) {
        this.dataDeContemplacao = dataDeContemplacao;
    }

}
