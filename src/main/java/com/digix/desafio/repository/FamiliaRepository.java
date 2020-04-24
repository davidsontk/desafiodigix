package com.digix.desafio.repository;

import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.model.Familia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author david
 */
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

    @Query("SELECT new com.digix.desafio.dto.FamiliaDTO(fm) FROM Familia fm "
            + " WHERE fm.statusId.id = ?1 ")
    List<FamiliaDTO> findByStatusId(Integer statusId);

}
