package com.digix.desafio.model;

import java.util.List;
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
@Table(name = "pessoa")
public class Familia {

    @Id
    @Column(name = "id")
    private String id;

    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private Status statusId;

    @JoinColumn(name = "pessoas_id", referencedColumnName = "id")
    @ManyToOne
    private List<Pessoa> pessoasId;
    
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private List<Renda> rendasId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public List<Pessoa> getPessoasId() {
        return pessoasId;
    }

    public void setPessoasId(List<Pessoa> pessoasId) {
        this.pessoasId = pessoasId;
    }

    public List<Renda> getRendasId() {
        return rendasId;
    }

    public void setRendasId(List<Renda> rendasId) {
        this.rendasId = rendasId;
    }
    
}
