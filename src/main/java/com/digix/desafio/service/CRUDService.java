package com.digix.desafio.service;

import com.digix.desafio.model.Familia;
import com.digix.desafio.model.FamiliaPessoa;
import com.digix.desafio.model.Pessoa;
import com.digix.desafio.model.Renda;
import com.digix.desafio.model.Status;
import com.digix.desafio.model.Tipo;
import com.digix.desafio.repository.FamiliaPessoaRepository;
import com.digix.desafio.repository.FamiliaRepository;
import com.digix.desafio.repository.PessoaRepository;
import com.digix.desafio.repository.RendaRepository;
import com.digix.desafio.repository.StatusRepository;
import com.digix.desafio.repository.TipoRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author davidson ferreira
 */
@Service
public class CRUDService {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Autowired
    private FamiliaPessoaRepository familiaPessoaRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private RendaRepository rendaRepository;

    public HttpStatus gerarDadosFake() {

        try {
            Status status1 = new Status();
            status1.setId(1);
            status1.setDescricao("Cadastro válido");
            statusRepository.save(status1);

            Status status2 = new Status();
            status2.setId(2);
            status2.setDescricao("Já possui uma casa");
            statusRepository.save(status2);

            Status status3 = new Status();
            status3.setId(3);
            status3.setDescricao("Selecionada em outro processo de seleção");
            statusRepository.save(status3);

            Status status4 = new Status();
            status4.setId(4);
            status4.setDescricao("Cadastro incompleto");
            statusRepository.save(status4);

            Tipo tipo1 = new Tipo();
            tipo1.setDescricao("Pretendente");
            tipo1.setId(1);
            tipoRepository.save(tipo1);

            Tipo tipo2 = new Tipo();
            tipo2.setDescricao("Cônjuge");
            tipo2.setId(2);
            tipoRepository.save(tipo2);

            Tipo tipo3 = new Tipo();
            tipo3.setDescricao("Dependente");
            tipo3.setId(3);
            tipoRepository.save(tipo3);

            Pessoa p1 = new Pessoa();
            p1.setId(1);
            p1.setNome("Davidson");
            p1.setTipoId(tipo1);
            p1.setDataDeNascimento(converteStringParaData("20/07/1969"));
            pessoaRepository.save(p1);

            Pessoa p2 = new Pessoa();
            p2.setId(2);
            p2.setNome("Moises");
            p2.setTipoId(tipo1);
            p2.setDataDeNascimento(converteStringParaData("07/01/1954"));
            pessoaRepository.save(p2);

            Pessoa p3 = new Pessoa();
            p3.setId(3);
            p3.setNome("Felipe");
            p3.setTipoId(tipo1);
            p3.setDataDeNascimento(converteStringParaData("23/04/1948"));
            pessoaRepository.save(p3);

            Pessoa p4 = new Pessoa();
            p4.setId(4);
            p4.setNome("Souza");
            p4.setTipoId(tipo1);
            p4.setDataDeNascimento(converteStringParaData("29/03/1992"));
            pessoaRepository.save(p4);

            Pessoa p5 = new Pessoa();
            p5.setId(5);
            p5.setNome("Davi Filho");
            p5.setTipoId(tipo3);
            p5.setDataDeNascimento(converteStringParaData("20/05/2007"));
            pessoaRepository.save(p5);

            Renda renda1 = new Renda();
            renda1.setId(1);
            renda1.setPessoaId(p1);
            renda1.setRenda(900);
            rendaRepository.save(renda1);

            Renda renda2 = new Renda();
            renda2.setId(2);
            renda2.setPessoaId(p2);
            renda2.setRenda(1000);
            rendaRepository.save(renda2);

            Renda renda3 = new Renda();
            renda3.setId(3);
            renda3.setPessoaId(p3);
            renda3.setRenda(2000);
            rendaRepository.save(renda3);

            Renda renda4 = new Renda();
            renda4.setId(4);
            renda4.setPessoaId(p4);
            renda4.setRenda(1200);
            rendaRepository.save(renda4);

            Familia f1 = new Familia();
            f1.setId(1);
            f1.setStatusId(status1);
            familiaRepository.save(f1);

            Familia f2 = new Familia();
            f2.setId(2);
            f2.setStatusId(status1);
            familiaRepository.save(f2);

            Familia f3 = new Familia();
            f3.setId(3);
            f3.setStatusId(status1);
            familiaRepository.save(f3);

            Familia f4 = new Familia();
            f4.setId(4);
            f4.setStatusId(status3);
            familiaRepository.save(f4);

            FamiliaPessoa fp1 = new FamiliaPessoa();
            fp1.setId(1);
            fp1.setFamiliaId(f1);
            fp1.setPessoaId(p1);
            familiaPessoaRepository.save(fp1);

            FamiliaPessoa fp2 = new FamiliaPessoa();
            fp2.setId(2);
            fp2.setFamiliaId(f2);
            fp2.setPessoaId(p2);
            familiaPessoaRepository.save(fp2);

            FamiliaPessoa fp3 = new FamiliaPessoa();
            fp3.setId(3);
            fp3.setFamiliaId(f3);
            fp3.setPessoaId(p3);
            familiaPessoaRepository.save(fp3);

            FamiliaPessoa fp4 = new FamiliaPessoa();
            fp4.setId(4);
            fp4.setFamiliaId(f4);
            fp4.setPessoaId(p4);
            familiaPessoaRepository.save(fp4);
            
            FamiliaPessoa fp5 = new FamiliaPessoa();
            fp5.setId(5);
            fp5.setFamiliaId(f1);
            fp5.setPessoaId(p5);
            familiaPessoaRepository.save(fp5);

            return HttpStatus.OK;

        } catch (Exception e) {
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;

        }

    }

    private java.sql.Date converteStringParaData(String dataString) {

        DateTimeFormatter formatter = null;
        if (dataString.contains("/")) {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dataString, formatter);
            java.sql.Date dateReturn = java.sql.Date.valueOf(date);

            return dateReturn;

        }
        return null;
    }

}
