package br.com.edward.restfull.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.edward.restfull.domain.Sala;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SalaModel {
	
	private Long id;
	private String nome;
	private TipoSalaModel tipo;
	
	public SalaModel(Sala domain) {
		
		this.id = domain.getId();
		this.nome = domain.getNome();
		this.tipo = new TipoSalaModel(domain.getTipo());
	}
	
	@JsonIgnore
	public Long getTipoSalaId() {
		return this.tipo.getId();
	}
	
	public String getTipo() {
		return this.tipo.getNome();
	}
}
