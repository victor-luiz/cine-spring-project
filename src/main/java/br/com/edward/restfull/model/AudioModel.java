package br.com.edward.restfull.model;

import br.com.edward.restfull.domain.Audio;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AudioModel {
	
	private Long id;
	private String nome;
	
	public AudioModel(Audio domain){
		this.id = domain.getId();
		this.nome = domain.getNome();
	}
}
