package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.edward.restfull.domain.Audio;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AudioModel {
	
	private Long id;
	
	@NotNull
	@Length(min = 1, max = 10)
	private String nome;
	
	public AudioModel(Audio domain){
		this.id = domain.getId();
		this.nome = domain.getNome();
	}
}
