package com.digix.desafio.repository;

import com.digix.desafio.model.FamiliaPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface FamiliaPessoaRepository extends JpaRepository<FamiliaPessoa, Long> {

}
