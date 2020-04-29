package com.digix.desafio.service;

import com.digix.desafio.dto.PessoaDTO;
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

    public List<PessoaDTO> buscarPessoasPorFamiliaId(Integer familiaId) {
        try {
            
            return pessoaRepository.buscarPessoasPorFamiliaId(familiaId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
