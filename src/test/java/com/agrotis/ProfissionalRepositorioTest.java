package com.agrotis;

import com.agrotis.controller.ProfissionalController;
import com.agrotis.entidade.Laboratorio;
import com.agrotis.entidade.Profissional;
import com.agrotis.entidade.Propriedade;
import com.agrotis.repositorio.ProfissionalRepositorio;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ProfissionalRepositorioTest {
    @Autowired private ProfissionalRepositorio rep;
    @Test
    public void testNovoProfissional() {
        Profissional prof = new Profissional();
        prof.setNome("Dyogo");
        prof.setDataInicial(Date.valueOf("2022-11-15"));
        prof.setDataFinal(Date.valueOf("2022-12-23"));
        prof.setObservacoes("Teste obs");
        prof.setCnpj("02.222.222/0001-22");

        Laboratorio lab = new Laboratorio();
        lab.setNome("Teste Lab");
        lab.setId(10);
        prof.setLaboratorio(lab);

        Propriedade prop = new Propriedade();
        prop.setId(11);
        lab.setNome("Prop test");
        prof.setPropriedade(prop);

        //Salvando
        Profissional profSalvo = rep.save(prof);

        Assertions.assertThat(profSalvo).isNotNull();
        Assertions.assertThat(profSalvo.getId()).isGreaterThan(0);

    }

    @Test
    public void testAtualizarProfissional() {
        //Atualizando profissional
        Integer profId = 1;
        Optional<Profissional> optProf = rep.findById(profId);
        Profissional prof = optProf.get();
        prof.setObservacoes("Atualizado");
        rep.save(prof);
        Profissional profAtualizado = rep.findById(profId).get();
        Assertions.assertThat(profAtualizado.getObservacoes()).isEqualTo("Atualizado");
    }

    @Test
    public void recuperaProfissional() {
        //Buscando profissional
        Integer profId = 1;
        Optional<Profissional> optProf = rep.findById(profId);
        Assertions.assertThat(optProf).isPresent();
        System.out.println(optProf.get());
    }

    @Test
    public void testExcluiProfissional() {
        //Excluindo
        Integer profId = 1;
        rep.deleteById(profId);
        Optional<Profissional> optProf = rep.findById(profId);
        Assertions.assertThat(optProf).isNotPresent();
    }

    @Test
    public void testListarProfissionais() {
        Iterable<Profissional> profs = rep.findAll();
        Assertions.assertThat(profs).hasSizeGreaterThan(0);

        for (Profissional prof : profs) {
            System.out.println(prof);
        }
    }
}
