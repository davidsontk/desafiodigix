package com.digix.desafio.dto;

import com.digix.desafio.model.Familia;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author david
 */
public class FamiliaDTO implements Comparator<FamiliaDTO> {

    private Integer id;
    private Integer status;
    private List<PessoaDTO> pessoas;
    private List<RendaDTO> rendas;
    private Integer pontos;

    public FamiliaDTO() {

    }

    public FamiliaDTO(Familia familia) {
        this.id = familia.getId();
        this.status = familia.getStatusId().getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<PessoaDTO> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<PessoaDTO> pessoas) {
        this.pessoas = pessoas;
    }

    public List<RendaDTO> getRendas() {
        return rendas;
    }

    public void setRendas(List<RendaDTO> rendas) {
        this.rendas = rendas;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    @Override
    public int compare(FamiliaDTO o1, FamiliaDTO o2) {
        return o1.getPontos().compareTo(o2.getPontos());
    }

}
