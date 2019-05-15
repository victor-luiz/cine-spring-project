package br.com.edward.restfull.service;

import java.util.List;

import br.com.edward.restfull.domain.Filme;
import br.com.edward.restfull.model.FilmeModel;

public interface FilmeService {

	Filme cadastrar(FilmeModel model);
	List<Filme> listar();
}
