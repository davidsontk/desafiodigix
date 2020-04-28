package com.digix.desafio.repository;

import com.digix.desafio.dto.PessoaDTO;
import com.digix.desafio.model.Pessoa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT new com.digix.desafio.dto.PessoaDTO(p, DATEDIFF('year' , now(), p.dataDeNascimento)) FROM Pessoa p "
            + "JOIN FamiliaPessoa fp ON fp.pessoaId.id = p.id "
            + "WHERE fp.familiaId.id = ?1 ")
    List<PessoaDTO> buscarPessoasPorFamiliaId(Integer familiaId);
}
