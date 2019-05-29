package br.com.edward.restfull.model;

import javax.validation.constraints.NotNull;

import br.com.edward.restfull.domain.Ingresso;
import br.com.edward.restfull.enuns.EnumTipoIngresso;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IngressoModel {
	
	private Long id;
	
	@NotNull
	private SessaoModel sessao;
	
	@NotNull
	private Integer lugar;
	
	@NotNull
	private EnumTipoIngresso preco;
	
	public IngressoModel(Ingresso domain) {
		this.id = domain.getId();
		this.sessao = new SessaoModel(domain.getSessao());
		this.lugar = domain.getLugar();
	}
	
	public Double getPreco() {
		if (EnumTipoIngresso.INTEIRA.equals(this.preco)) {
			return this.getSessao().getSala().getTipo().getPreco();
		} else {
			return this.getSessao().getSala().getTipo().getMeiaEntrada();
		}
	}
	
}
