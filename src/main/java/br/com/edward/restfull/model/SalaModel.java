package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.edward.restfull.domain.Sala;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SalaModel {
	
	private Long id;
	
	@NotNull
	@Length(min = 3, max = 10)
	private String nome;
	
	@NotNull
	private TipoSalaModel tipo;
	
	@NotNull
	private Integer capacidade;
	
	public SalaModel(Sala domain) {
		
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.tipo = new TipoSalaModel(domain.getTipo());
		this.capacidade = domain.getCapacidade();
	}
}
