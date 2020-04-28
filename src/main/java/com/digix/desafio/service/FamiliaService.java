package com.digix.desafio.service;

import com.digix.desafio.StarterApplication;
import com.digix.desafio.dto.FamiliaContempladaDTO;
import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.dto.PessoaDTO;
import com.digix.desafio.dto.RendaDTO;
import com.digix.desafio.model.FamiliaContemplada;
import com.digix.desafio.model.Status;
import com.digix.desafio.repository.FamiliaContempladaRepository;
import com.digix.desafio.repository.FamiliaPessoaRepository;
import com.digix.desafio.repository.FamiliaRepository;
import com.digix.desafio.repository.PessoaRepository;
import com.digix.desafio.repository.StatusRepository;
import com.digix.desafio.repository.TipoRepository;
import com.digix.desafio.utils.Dependente;
import com.digix.desafio.utils.StatusEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author david
 */
@Service
public class FamiliaService {

    @Autowired
    private FamiliaPessoaRepository familiaPessoaRepository;

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private RendaService rendaService;

    @Autowired
    private CriterioService criterioService;

    @Autowired
    private FamiliaContempladaRepository familiaContempladaRepository;

    public List<FamiliaDTO> buscarFamiliasAptas() {

        try {
            Status status = statusRepository.findByDescricao(StatusEnum.CADASTRO_VALIDO);
            List<FamiliaDTO> listaFamiliaDTO = familiaRepository.findByStatusId(status.getId()); // buscando familias

            // preenchendo pessoas e rendas das familias e pontuacao e ordenação 
            listaFamiliaDTO = this.buscarFamiliasAptas(listaFamiliaDTO);

            return listaFamiliaDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private List<FamiliaDTO> buscarFamiliasAptas(List<FamiliaDTO> listaFamiliaDTO) {
        try {
            for (FamiliaDTO familiaDTO : listaFamiliaDTO) {
                List<PessoaDTO> pessoasDTO = pessoaService.buscarPessoasPorFamiliaId(familiaDTO.getId());
                List<RendaDTO> listaRenda = new ArrayList<>();
                familiaDTO.setPessoas(pessoasDTO);

                for (PessoaDTO pessoa : pessoasDTO) {
                    if (!pessoa.getTipo().equals(Dependente.DEPENDENTE)) {
                        RendaDTO rendaDTO = rendaService.buscarRendaPorPessoa(pessoa.getId());
                        if (rendaDTO != null) {
                            listaRenda.add(rendaDTO);
                        }
                    }
                }

                familiaDTO.setRendas(listaRenda);

                Integer criteriosAtendidos = 0;
                Integer pontos = familiaDTO.getPontos();
                // verificando criterio de renda total
                criterioService.verificarCriterioRendaTotalFamilia(familiaDTO);

                if (!pontos.equals(familiaDTO.getPontos())) {
                    criteriosAtendidos++;
                    pontos = familiaDTO.getPontos();
                }
                //verificando criterio de pretendente
                criterioService.verificarCriterioPretendentePorFamilia(familiaDTO);

                if (!pontos.equals(familiaDTO.getPontos())) {
                    criteriosAtendidos++;
                    pontos = familiaDTO.getPontos();
                }
                //verificando criterio de dependente
                criterioService.verificarCriterioDependentePorFamilia(familiaDTO);

                if (!pontos.equals(familiaDTO.getPontos())) {
                    criteriosAtendidos++;
                    pontos = familiaDTO.getPontos();
                }

                // salvando na tabela de familias contempladas
                this.salvarFamiliaContemplada(criteriosAtendidos, familiaDTO.getId(), familiaDTO.getPontos());
            }

            Collections.sort(listaFamiliaDTO, new FamiliaDTO());
            // ordenando familia

            return listaFamiliaDTO;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void salvarFamiliaContemplada(Integer criteriosAtendidos, Integer familiaId, Integer pontuacaoTotal) {
        try {
            FamiliaContemplada familiaContemplada = new FamiliaContemplada();
            familiaContemplada.setId(familiaId);
            familiaContemplada.setCriterioAtendido(criteriosAtendidos);
            familiaContemplada.setDataContemplacao(new Date());
            familiaContemplada.setFamiliaId(familiaRepository.findById(familiaId));
            familiaContemplada.setPontuacaoTotal(pontuacaoTotal);

            familiaContempladaRepository.save(familiaContemplada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<Page> buscarFamiliasContempladas(int numeroPagina, int tamanhoPagina) {
        Pageable pageable;

        try {
            pageable = PageRequest.of(numeroPagina, tamanhoPagina);
            Page<FamiliaContempladaDTO> pagina = familiaContempladaRepository.buscarFamiliasContempladasPorPagina(pageable);

//            Page<FamiliaContempladaDTO> paginaPronta = new PageImpl<>(
//                    pagina.getContent().stream()
//                            .map(familiaContemplada -> this.transformarFamiliaContempladaEmDTO(familiaContemplada)).collect(Collectors.toList()),
//                    pageable, pagina.getTotalElements()
//            );
            return new ResponseEntity<>(pagina, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

}
