package br.com.alura.forum;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest /*Anotação do Sprint boot teste ,para poder utilizar Repository*/
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) /*NAO SUBSTITUIR AS CONFIG BANCO*/
@ActiveProfiles("test")
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    @Test
    public void deveriaCarregarUmCursoAoBuscarPeloSeuNome(){
        String nomeCurso = "HTML 5";
        Curso curso = repository.findByNome(nomeCurso);
        Assert.assertNotNull(curso);
        Assert.assertEquals(nomeCurso,curso.getNome());
    }

    @Test
    public void naoDeveriaCarregarUmCursoNaoCadastrado(){
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);
        Assert.assertNull(curso);
       // Assert.assertEquals(nomeCurso,curso.getNome());
    }
}
