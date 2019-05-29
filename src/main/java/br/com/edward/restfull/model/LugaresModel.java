package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import br.com.edward.restfull.domain.Lugares;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LugaresModel {

	private Long id;
	
	@NotNull	
	private Integer numero;
	
	public LugaresModel(Lugares domain){
		
		this.id = domain.getId();
		this.numero = domain.getNumero();
	}
}
