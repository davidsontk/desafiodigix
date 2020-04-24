package com.digix.desafio.service;

import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.model.Familia;
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
    FamiliaPessoaRepository familiaPessoaRepository;

    @Autowired
    FamiliaRepository familiaRepository;

    @Autowired
    TipoRepository tipoRepository;

    @Autowired
    StatusRepository statusRepository;

    public List<FamiliaDTO> buscarFamiliasAptas() {

        try {
            Status status = statusRepository.findByDescricao(StatusEnum.CADASTRO_VALIDO);
            List<FamiliaDTO> listaFamiliaDTO = familiaRepository.findByStatusId(status.getId());
            // popular objeto primeiro
            

            return listaFamiliaDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
