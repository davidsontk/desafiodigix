package com.digix.desafio.service;

import com.digix.desafio.dto.RendaDTO;
import com.digix.desafio.repository.RendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davidson ferreira
 */
@Service
public class RendaService {

    @Autowired
    private RendaRepository rendaRepository;

    public RendaDTO buscarRendaPorPessoa(Integer pessoaId) {
        try {
            return rendaRepository.findByPessoaId(pessoaId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
