package br.com.edward.restfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.*;

@SpringBootApplication
@EnableJpaAuditing
public class ProjetoSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringMvcApplication.class, args);
	}

}
