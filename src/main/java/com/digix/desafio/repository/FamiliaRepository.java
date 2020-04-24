package com.digix.desafio.repository;

import com.digix.desafio.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author david
 */
public interface FamiliaRepository extends JpaRepository<Familia, Long>{
    
}
