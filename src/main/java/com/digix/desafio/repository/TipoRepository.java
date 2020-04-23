package com.digix.desafio.repository;

import com.digix.desafio.model.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface TipoRepository  extends JpaRepository<Tipo, Long>{
    
   
}
