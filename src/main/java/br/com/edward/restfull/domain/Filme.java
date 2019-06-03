package br.com.edward.restfull.domain;

import java.util.List;

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

import br.com.edward.restfull.model.FilmeModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

@Entity
@Table(name = "filme")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "nome", length = 124)
	private String nome;
	
	@NotNull
	@Column(name = "ano")
	private Integer ano;
	
	@Column(name = "sinopse")
	private String sinopse;
	
	@OneToMany(mappedBy = "filme", targetEntity = FilmeCategoria.class, cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private List<Categoria> categorias;
	
	public Filme(FilmeModel model, List<Categoria> categorias) {
		this.nome = model.getNome();
		this.ano = model.getAno();
		this.sinopse = model.getSinopse();
		this.categorias = categorias;
	}
}
