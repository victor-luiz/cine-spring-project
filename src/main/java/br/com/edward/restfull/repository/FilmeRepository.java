package br.com.edward.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.edward.restfull.domain.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
