package com.digix.desafio.dto;

import com.digix.desafio.model.Pessoa;
import java.util.Date;

/**
 *
 * @author david
 */
public class PessoaDTO {

    private String id;
    private String nome;
    private Date dataDeNascimento;
    private int idade;

    public PessoaDTO(Pessoa pessoa, int idade) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataDeNascimento = pessoa.getDataDeNascimento();
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}