package com.digix.desafio.repository;

import com.digix.desafio.model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author david
 */
public interface RendaRepository extends JpaRepository<Renda, Long>{
    
}
