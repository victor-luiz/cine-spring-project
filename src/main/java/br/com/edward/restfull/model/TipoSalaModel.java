package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.edward.restfull.domain.TipoSala;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TipoSalaModel {
	
	private Long id;
	
	@NotNull
	@Length(min = 2, max = 10)
	private String nome;
	
	@NotNull
	private Double preco;
	
	private Double meiaEntrada;
	
	
	public TipoSalaModel(TipoSala domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.preco = domain.getPreco();
		this.meiaEntrada = domain.gerarMeiaEntrada();
	}
}
