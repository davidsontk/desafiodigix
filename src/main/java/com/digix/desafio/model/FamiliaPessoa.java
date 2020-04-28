package com.digix.desafio.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table(name = "familia_pessoa")
public class FamiliaPessoa implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne
    private Pessoa pessoaId;

    @JoinColumn(name = "familia_id", referencedColumnName = "id")
    @ManyToOne
    private Familia familiaId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Pessoa pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Familia getFamiliaId() {
        return familiaId;
    }

    public void setFamiliaId(Familia familiaId) {
        this.familiaId = familiaId;
    }

}
