package com.digix.desafio.repository;

import com.digix.desafio.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author david
 */
public interface StatusRepository extends JpaRepository<Status, Long>{
    
    Status findByDescricao(String descricao);
}
