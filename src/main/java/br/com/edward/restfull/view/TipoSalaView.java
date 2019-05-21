package br.com.edward.restfull.view;

import br.com.edward.restfull.model.TipoSalaModel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TipoSalaView {
	
	private Long id;
	private String nome;
	
	public TipoSalaView(TipoSalaModel model) {
		
		this.id = model.getId();
		this.nome = model.getNome();
	}

}
