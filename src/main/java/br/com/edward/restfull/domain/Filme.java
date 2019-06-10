package br.com.edward.restfull.domain;

import java.util.List;

import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "filme_gen")
	@SequenceGenerator(name = "filme_gen", sequenceName = "filme_id_seq", allocationSize = -1)
	private Long id;

	private String nome;

	private Integer ano;

	private Integer duracao;

	private Integer classificacao;

	private String sinopse;
	
	@OneToMany(mappedBy = "filme")
    private List<FilmeCategoria> categorias;
	
	public Filme(FilmeModel model) {
		this.nome = model.getNome();
		this.ano = model.getAno();
		this.sinopse = model.getSinopse();
		this.classificacao = model.getClassificacao();
		this.duracao = model.getDuracao();
	}
}
