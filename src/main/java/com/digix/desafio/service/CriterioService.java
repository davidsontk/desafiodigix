package com.digix.desafio.service;

import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.dto.PessoaDTO;
import com.digix.desafio.dto.RendaDTO;
import com.digix.desafio.utils.Pontos;
import com.digix.desafio.utils.Pretendente;
import com.digix.desafio.utils.RendaTotal;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class CriterioService {

    public FamiliaDTO verificarCriterioRentaTotalFamilia(FamiliaDTO familiaDTO) {
        List<RendaDTO> listaRendas = familiaDTO.getRendas();
        int rendaTotal = 0;

        for (RendaDTO renda : listaRendas) {
            rendaTotal += renda.getRenda();
        }

        if (rendaTotal <= RendaTotal.ATE900) {
            familiaDTO.setPontos(familiaDTO.getPontos() + Pontos.PONTO5);
            return familiaDTO;
        }

        if (rendaTotal <= RendaTotal.ATE1500) {
            familiaDTO.setPontos(familiaDTO.getPontos() + Pontos.PONTO3);
            return familiaDTO;
        }

        if (rendaTotal <= RendaTotal.ATE2000) {
            familiaDTO.setPontos(familiaDTO.getPontos() + Pontos.PONTO1);
            return familiaDTO;
        }

        return familiaDTO;
    }

    public FamiliaDTO verificarCriterioPretendentePorFamilia(FamiliaDTO familiaDTO) {
        List<PessoaDTO> listaPessoas = familiaDTO.getPessoas();
        PessoaDTO pessoaPretendente = null;
        for (PessoaDTO pessoa : listaPessoas) {
            if (pessoa.getTipo().equals(Pretendente.PRETENDENTE)) {
                pessoaPretendente = pessoa;
                break;
            }
        }

        if (pessoaPretendente.getIdade() <= Pretendente.ATE30ANOS) {
            familiaDTO.setPontos(familiaDTO.getPontos() + Pontos.PONTO1);
            return familiaDTO;
        }

        if (pessoaPretendente.getIdade() <= Pretendente.ATE44ANOS) {
            familiaDTO.setPontos(familiaDTO.getPontos() + Pontos.PONTO2);
            return familiaDTO;
        }

        if (pessoaPretendente.getIdade() >= Pretendente.ACIMA45ANOS) {
            familiaDTO.setPontos(familiaDTO.getPontos() + Pontos.PONTO3);
            return familiaDTO;
        }
        
        return familiaDTO;

    }

}
