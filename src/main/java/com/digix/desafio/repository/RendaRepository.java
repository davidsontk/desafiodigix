package com.digix.desafio.repository;

import com.digix.desafio.model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface RendaRepository extends JpaRepository<Renda, Long>{
    
    @Query("SELECT r FROM Renda r "
            + "WHERE r.pessoaId.id = ?1")
    Renda findByPessoaId(String pessoaId);
}
