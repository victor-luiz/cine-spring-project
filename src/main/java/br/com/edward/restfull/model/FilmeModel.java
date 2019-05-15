package br.com.edward.restfull.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.edward.restfull.domain.Filme;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FilmeModel {
	
	private Long id;
	private String nome;
	private Integer ano;
	private String sinopse;
	private CategoriaModel categoria;
	
	public FilmeModel(Filme domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.ano = domain.getAno();
		this.sinopse = Objects.nonNull(domain.getSinopse()) ? domain.getSinopse() : "-";
		this.categoria = new CategoriaModel(domain.getCategoria());
	}
	
	@JsonIgnore
	public Long getIdCategoria() {
		return this.categoria.getId();
	}
	
	public String getCategoria() {
		return this.categoria.getNome();
	}
	
}
