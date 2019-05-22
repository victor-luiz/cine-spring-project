package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import br.com.edward.restfull.domain.Sessao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SessaoModel {
	
	private Long id;
	
	@NotNull
	private FilmeModel filme;
	
	@NotNull
	private SalaModel sala;
	
	@NotNull
	private AudioModel audio;
	
	private Boolean[] lugares;
	
	public SessaoModel(Sessao domain) {
		
		this.id = domain.getId();
		this.filme = new FilmeModel(domain.getFilme());
		this.sala = new SalaModel(domain.getSala());
		this.audio = new AudioModel(domain.getAudio());
		this.lugares = domain.getLugares(); 
	}
}
