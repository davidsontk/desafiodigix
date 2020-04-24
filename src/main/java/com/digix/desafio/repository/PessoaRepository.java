package com.digix.desafio.repository;

import com.digix.desafio.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author david
 */
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    
}
