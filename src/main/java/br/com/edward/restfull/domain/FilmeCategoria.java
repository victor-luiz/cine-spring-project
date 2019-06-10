package br.com.edward.restfull.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter

@Entity
@Table(name = "filme_categoria")
public class FilmeCategoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "filme_categoria_gen")
	@SequenceGenerator(name = "filme_categoria_gen", sequenceName = "filme_categoria_id_seq", allocationSize = -1)
	private Long id;

	@ManyToOne
    @JoinColumn(name = "filme_id")
	private Filme filme;
	
	@ManyToOne
    @JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	public FilmeCategoria(Filme filme, Categoria categoria) {
		
		this.categoria = categoria;
		this.filme = filme;
	}
	
}
