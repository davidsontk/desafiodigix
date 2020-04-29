package com.digix.desafio.service;

import com.digix.desafio.dto.FamiliaDTO;
import com.digix.desafio.dto.PessoaDTO;
import com.digix.desafio.dto.RendaDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author david
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CriterioServiceTest {

    @Autowired
    private CriterioService criterioService;

    public CriterioServiceTest() {
    }

    /**
     * Test of verificarCriterioRendaTotalFamilia method, of class
     * CriterioService.
     */
    @Test
    public void testVerificarCriterioRendaTotalFamilia() {
        System.out.println("verificarCriterioRendaTotalFamilia");
        FamiliaDTO f = new FamiliaDTO();
        f.setId(1);
        f.setPontos(0);
        f.setStatus(1);
        List<RendaDTO> listaRendas = new ArrayList<>();

        RendaDTO renda1 = new RendaDTO();
        renda1.setPessoaId(1);
        renda1.setRenda(950);
        listaRendas.add(renda1);

        RendaDTO renda2 = new RendaDTO();
        renda2.setPessoaId(2);
        renda2.setRenda(1000);
        listaRendas.add(renda2);

        f.setRendas(listaRendas);

        // Status Cadastro valido
        FamiliaDTO familiaAntes = f;
        FamiliaDTO familiaDepois = criterioService.verificarCriterioRendaTotalFamilia(f);

        assertEquals(familiaAntes, familiaDepois);

    }

    /**
     * Test of verificarCriterioPretendentePorFamilia method, of class
     * CriterioService.
     */
    @Test
    public void testVerificarCriterioPretendentePorFamilia() {
        System.out.println("verificarCriterioPretendentePorFamilia");

        FamiliaDTO f = new FamiliaDTO();
        f.setId(1);
        f.setPontos(0);
        f.setStatus(1);
        List<PessoaDTO> listaPessoas = new ArrayList<>();

        PessoaDTO p1 = new PessoaDTO();
        p1.setDataDeNascimento("20/07/1989");
        p1.setId(1);
        p1.setIdade(30);
        p1.setNome("Joao");
        p1.setTipo("Pretendente");
        listaPessoas.add(p1);

        PessoaDTO p2 = new PessoaDTO();
        p2.setDataDeNascimento("10/05/1990");
        p2.setId(2);
        p2.setIdade(29);
        p2.setNome("Maria");
        p2.setTipo("Cônjuge");
        listaPessoas.add(p2);

        PessoaDTO p3 = new PessoaDTO();
        p3.setDataDeNascimento("20/05/2007");
        p3.setId(3);
        p3.setIdade(12);
        p3.setNome("Filho");
        p3.setTipo("Dependente");
        listaPessoas.add(p3);

        f.setPessoas(listaPessoas);

        FamiliaDTO result = criterioService.verificarCriterioPretendentePorFamilia(f);
        assertNotNull(result);

    }

    /**
     * Test of verificarCriterioDependentePorFamilia method, of class
     * CriterioService.
     */
    @Test
    public void testVerificarCriterioDependentePorFamilia() {
        System.out.println("verificarCriterioDependentePorFamilia");

        FamiliaDTO f = new FamiliaDTO();
        f.setId(1);
        f.setPontos(0);
        f.setStatus(1);
        List<PessoaDTO> listaPessoas = new ArrayList<>();

        PessoaDTO p1 = new PessoaDTO();
        p1.setDataDeNascimento("20/07/1989");
        p1.setId(1);
        p1.setIdade(31);
        p1.setNome("Joao");
        p1.setTipo("Pretendente");
        listaPessoas.add(p1);

        PessoaDTO p2 = new PessoaDTO();
        p2.setDataDeNascimento("10/05/1990");
        p2.setId(2);
        p2.setIdade(30);
        p2.setNome("Maria");
        p2.setTipo("Cônjuge");
        listaPessoas.add(p2);

        PessoaDTO p3 = new PessoaDTO();
        p3.setDataDeNascimento("20/05/2007");
        p3.setId(3);
        p3.setIdade(12);
        p3.setNome("Filho");
        p3.setTipo("Dependente");
        listaPessoas.add(p3);

        f.setPessoas(listaPessoas);

        FamiliaDTO expResult = null;
        FamiliaDTO result = criterioService.verificarCriterioDependentePorFamilia(f);
        assertNotNull(result);
        assertEquals(f, result);

    }

}
