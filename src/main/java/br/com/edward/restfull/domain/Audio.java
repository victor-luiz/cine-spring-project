package br.com.edward.restfull.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.edward.restfull.model.AudioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter

@Entity
@Table(name = "audio")
public class Audio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "audio_gen")
	@SequenceGenerator(name = "audio_gen", sequenceName = "audio_id_seq", allocationSize = -1)
	private Long id;

	private String nome;

	@OneToMany(mappedBy = "audio")
	private List<Sessao> sessoes;

	public Audio(AudioModel model){
		this.nome = model.getNome();
	}
}