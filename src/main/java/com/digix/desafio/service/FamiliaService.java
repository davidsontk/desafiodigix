package com.digix.desafio.service;

import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.dto.PessoaDTO;
import com.digix.desafio.model.Familia;
import com.digix.desafio.model.Renda;
import com.digix.desafio.model.Status;
import com.digix.desafio.repository.FamiliaPessoaRepository;
import com.digix.desafio.repository.FamiliaRepository;
import com.digix.desafio.repository.StatusRepository;
import com.digix.desafio.repository.TipoRepository;
import com.digix.desafio.utils.StatusEnum;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    public List<FamiliaDTO> buscarFamiliasAptas() {
        
        try {
            Status status = statusRepository.findByDescricao(StatusEnum.CADASTRO_VALIDO);
            List<FamiliaDTO> listaFamiliaDTO = familiaRepository.findByStatusId(status.getId()); // buscando familias
            listaFamiliaDTO = this.buscarFamiliasAptas(listaFamiliaDTO); // preenchendo pessoas e rendas das familias
            
            // começar logica do codigo
            // fazer um service de criterios e jogar a logica lá.
            // verificar a necessidade de criar uma data_de_comtemplado na tabela familia
            
            return listaFamiliaDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
    private List<FamiliaDTO> buscarFamiliasAptas(List<FamiliaDTO> listaFamiliaDTO) {
        for (FamiliaDTO familiaDTO : listaFamiliaDTO) {
            List<PessoaDTO> pessoasDTO = pessoaService.buscarPessoasPorFamiliaId(familiaDTO.getId());
            List<Renda> listaRenda = new ArrayList<>();
            familiaDTO.setPessoas(pessoasDTO);
            for (PessoaDTO pessoa : pessoasDTO) {
                listaRenda.add(rendaService.buscarRendaPorPessoa(pessoa.getId()));
            }
            familiaDTO.setRendas(listaRenda);
        }
        
        return listaFamiliaDTO;
    }
    
}
