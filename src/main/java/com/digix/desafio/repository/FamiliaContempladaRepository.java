package com.digix.desafio.repository;

import com.digix.desafio.dto.FamiliaContempladaDTO;
import com.digix.desafio.model.FamiliaContemplada;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface FamiliaContempladaRepository extends JpaRepository<FamiliaContemplada, Long> {

    
    @Query("SELECT new com.digix.desafio.dto.FamiliaContempladaDTO(fc) FROM FamiliaContemplada fc "
            + "ORDER BY fc.dataContemplacao DESC ")
    Page<FamiliaContempladaDTO> buscarFamiliasContempladasPorPagina(Pageable pageable);
}
