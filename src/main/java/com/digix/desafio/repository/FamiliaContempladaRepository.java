package com.digix.desafio.repository;

import com.digix.desafio.model.FamiliaContemplada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davidson ferreira
 */
@Repository
public interface FamiliaContempladaRepository extends JpaRepository<FamiliaContemplada, Long> {

}
