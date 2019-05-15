package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.TipoSala;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TipoSalaModel {
	
	private Long id;
	private String nome;
	
	public TipoSalaModel(TipoSala domain) {
		this.id = domain.getId();
		this.nome = domain.getNome();
	}
}
