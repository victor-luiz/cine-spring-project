package br.com.edward.restfull.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.edward.restfull.domain.FilmeCategoria;
import org.hibernate.validator.constraints.Length;

import br.com.edward.restfull.domain.Filme;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FilmeModel {
	
	private Long id;
	
	@NotNull
	@Length(min = 3, max = 124)
	private String nome;

	@NotNull
	private Integer ano;

	@NotNull
	private Integer duracao;

	@NotNull
	private Integer classificacao;
	
	@NotNull
	@Length(min = 3, max = 2000)
	private String sinopse;
	
	private List<CategoriaModel> categorias;
	
	public FilmeModel(Filme domain) {
		
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.ano = domain.getAno();
		this.sinopse = Objects.nonNull(domain.getSinopse()) ? domain.getSinopse() : "-";
		this.categorias = domain.getCategorias().stream().map(FilmeCategoria::getCategoria).map(CategoriaModel::new).collect(Collectors.toList());
		this.classificacao = domain.getClassificacao();
		this.duracao = domain.getDuracao();
	}	
}
