package br.com.edward.restfull.RepositoryTest;

import br.com.edward.restfull.domain.*;
import br.com.edward.restfull.model.*;
import br.com.edward.restfull.repository.*;
import org.assertj.core.api.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.junit4.*;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoriaRepositoryTest {

    @Autowired
    CategoriaRepository repository;

    @Test
    public void listaCartegoriaTest(){
        List<Categoria> categorias = repository.findAll();

        Assertions.assertThat(categorias.size()).isEqualTo(5);
    }
}
