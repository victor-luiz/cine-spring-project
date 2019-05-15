package br.com.edward.restfull.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.edward.restfull.domain.Sessao;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SessaoModel {
	
	private Long id;
	private FilmeModel filme;
	private SalaModel sala;
	private AudioModel audio;
	
	public SessaoModel(Sessao domain) {
		
		this.id = domain.getId();
		this.filme = new FilmeModel(domain.getFilme());
		this.sala = new SalaModel(domain.getSala());
		this.audio = new AudioModel(domain.getAudio());
	}
	
	@JsonIgnore
	public Long getFilmeId() {
		return this.filme.getId();
	}
	
	@JsonIgnore
	public Long getSalaId() {
		return this.sala.getId();
	}
	
	@JsonIgnore
	public Long getAudioId() {
		return this.audio.getId();
	}
	
	public String getFilme() {
		return this.filme.getNome();
	}
	
	public String getSala() {
		return this.sala.getNome();
	}
	
	public String getAudio() {
		return this.audio.getNome();
	}
}
