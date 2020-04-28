package com.digix.desafio.dto;

import com.digix.desafio.model.Pessoa;
import com.digix.desafio.utils.UtilitariosHelper;

/**
 *
 * @author david
 */
public class PessoaDTO {

    private Integer id;
    private String nome;
    private String dataDeNascimento;
    private String tipo;
    private Integer idade;

    public PessoaDTO() {

    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataDeNascimento = UtilitariosHelper.formatarData(pessoa.getDataDeNascimento());
        this.tipo = pessoa.getTipoId().getDescricao();
        this.idade = UtilitariosHelper.calcularIdade(pessoa.getDataDeNascimento());
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

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}
