package com.digix.desafio.service;

import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.dto.PessoaDTO;
import com.digix.desafio.repository.FamiliaPessoaRepository;
import com.digix.desafio.repository.PessoaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davidson ferreira
 */
@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> buscarPessoasPorFamiliaId(String familiaId) {
        try {
            
            return pessoaRepository.findByFamiliaId(familiaId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
