package com.digix.desafio.service;

import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.dto.PessoaDTO;
import com.digix.desafio.dto.RendaDTO;
import com.digix.desafio.utils.Dependente;
import com.digix.desafio.utils.Ponto;
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

    public FamiliaDTO verificarCriterioRendaTotalFamilia(FamiliaDTO familiaDTO) {
        try {
            List<RendaDTO> listaRendas = familiaDTO.getRendas();
            Integer rendaTotal = 0;

            for (RendaDTO renda : listaRendas) {
                rendaTotal += renda.getRenda();
            }

            if (rendaTotal <= RendaTotal.ATE_900) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_5);
                return familiaDTO;
            }

            if (rendaTotal <= RendaTotal.ATE_1500) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_3);
                return familiaDTO;
            }

            if (rendaTotal <= RendaTotal.ATE_2000) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_1);
                return familiaDTO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return familiaDTO;
    }

    public FamiliaDTO verificarCriterioPretendentePorFamilia(FamiliaDTO familiaDTO) {
        try {
            List<PessoaDTO> listaPessoas = familiaDTO.getPessoas();
            PessoaDTO pessoaPretendente = null;
            for (PessoaDTO pessoa : listaPessoas) {
                if (pessoa.getTipo().equals(Pretendente.PRETENDENTE)) {
                    pessoaPretendente = pessoa;
                    break;
                }
            }

            if (pessoaPretendente.getIdade() <= Pretendente.ATE_30_ANOS) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_1);
                return familiaDTO;
            }

            if (pessoaPretendente.getIdade() <= Pretendente.ATE_44_ANOS) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_2);
                return familiaDTO;
            }

            if (pessoaPretendente.getIdade() >= Pretendente.ACIMA_45_ANOS) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_3);
                return familiaDTO;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return familiaDTO;
    }

    public FamiliaDTO verificarCriterioDependentePorFamilia(FamiliaDTO familiaDTO) {
        try {
            List<PessoaDTO> listaPessoas = familiaDTO.getPessoas();
            int dependentesMenoresDe18Anos = 0;
            for (PessoaDTO pessoa : listaPessoas) {
                if (pessoa.getTipo().equals(Dependente.DEPENDENTE)) {
                    if (pessoa.getIdade() <= 18) {
                        dependentesMenoresDe18Anos++;
                    }
                }
            }

            if (dependentesMenoresDe18Anos == 0) {
                //caso n tenha dependentes
                return familiaDTO;
            }

            if (dependentesMenoresDe18Anos <= Dependente.ATE_2_DEPENDENTES) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_2);
                return familiaDTO;
            }

            if (dependentesMenoresDe18Anos >= Dependente.DE_3_DEPENDENTES) {
                familiaDTO.setPontos(familiaDTO.getPontos() + Ponto.PONTO_3);
                return familiaDTO;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return familiaDTO;
    }

}
