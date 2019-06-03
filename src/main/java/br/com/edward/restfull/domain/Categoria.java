package br.com.edward.restfull.domain;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.CategoriaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name="nome", length = 20)
	private String nome;
	
	@OneToMany(mappedBy = "categoria", targetEntity = FilmeCategoria.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Filme> filmes;
	
	public Categoria(CategoriaModel model) {
		this.nome = model.getNome();
		this.filmes = model.getFilmes().stream().map(Filme::new).collect(Collectors.toList()); 
	}
	
}
