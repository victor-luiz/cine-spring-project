package br.com.edward.restfull.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.CategoriaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "categoria_gen")
	@SequenceGenerator(name = "categoria_gen", sequenceName = "categoria_id_seq", allocationSize = -1)
	private Long id;

	private String nome;

	@OneToMany(mappedBy = "categoria")
    private List<FilmeCategoria> filmes;
	
	public Categoria(CategoriaModel model) {
		this.nome = model.getNome(); 
	}
	
}
