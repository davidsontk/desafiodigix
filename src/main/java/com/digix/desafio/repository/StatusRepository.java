package com.digix.desafio.repository;

import com.digix.desafio.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{
    
    Status findByDescricao(String descricao);
}
