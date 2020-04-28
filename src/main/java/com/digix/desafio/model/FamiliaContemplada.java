package com.digix.desafio.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author davidson ferreira
 */
@Entity
@Table(name = "familia_contemplada")
public class FamiliaContemplada implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "familia_id", referencedColumnName = "id")
    @ManyToOne
    private Familia familiaId;

    @Column(name = "criterio_atendido")
    private Integer criterioAtendido;

    @Column(name = "pontuacao_total")
    private Integer pontuacaoTotal;

    @Column(name = "data_contemplacao")
    private Date dataContemplacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Familia getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(Familia familiaId) {
        this.familiaId = familiaId;
    }

    public Integer getCriterioAtendido() {
        return criterioAtendido;
    }

    public void setCriterioAtendido(Integer criterioAtendido) {
        this.criterioAtendido = criterioAtendido;
    }

    public Integer getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public void setPontuacaoTotal(Integer pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public Date getDataContemplacao() {
        return dataContemplacao;
    }

    public void setDataContemplacao(Date dataContemplacao) {
        this.dataContemplacao = dataContemplacao;
    }

}
