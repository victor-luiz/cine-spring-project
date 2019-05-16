package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	public String getCategoria() {
		return this.filme.getCategoria();
	}
	
	public String getSala() {
		return this.sala.getNome();
	}
	
	public String getAudio() {
		return this.audio.getNome();
	}
	
	public String getTipoSala() {
		return this.sala.getTipo();
	}
	
	public Double getIngressoInteira() {
		return this.sala.getTipoSalaModel().getPreco();
	}
	
	public Double getIngressoMeiaEntrada() {
		return this.sala.getTipoSalaModel().getMeiaEntrada();
	}
}
