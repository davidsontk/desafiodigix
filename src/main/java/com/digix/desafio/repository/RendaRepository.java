package com.digix.desafio.repository;

import com.digix.desafio.dto.RendaDTO;
import com.digix.desafio.model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface RendaRepository extends JpaRepository<Renda, Long>{
    
    @Query("SELECT new com.digix.desafio.dto.RendaDTO(r) FROM Renda r "
            + "WHERE r.pessoaId.id = ?1")
    RendaDTO findByPessoaId(Integer pessoaId);
}
