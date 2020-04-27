package com.digix.desafio.dto;

import com.digix.desafio.model.Pessoa;
import java.util.Date;

/**
 *
 * @author david
 */
public class PessoaDTO {

    private Integer id;
    private String nome;
    private Date dataDeNascimento;
    private String tipo;
    private int idade;

    public PessoaDTO(Pessoa pessoa, int idade) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataDeNascimento = pessoa.getDataDeNascimento();
        this.tipo = pessoa.getTipoId().getDescricao();
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
