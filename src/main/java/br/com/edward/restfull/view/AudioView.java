package br.com.edward.restfull.view;

import br.com.edward.restfull.model.AudioModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AudioView {
	
	private Long id;
	private String nome;
	
	public AudioView(AudioModel model) {
		
		this.id = model.getId();
		this.nome = model.getNome();
	}

}
