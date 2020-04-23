package com.digix.desafio.model;

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
@Table
public class Renda {
    
    
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "renda")
    private Integer renda;
    
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
    @ManyToOne
    private String pessoaId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRenda() {
        return renda;
    }

    public void setRenda(Integer renda) {
        this.renda = renda;
    }

    public String getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(String pessoaId) {
        this.pessoaId = pessoaId;
    } 
    
}
