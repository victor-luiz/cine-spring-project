package br.com.edward.restfull.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnunTipoIngresso {
	
	INTEIRA,
	MEIA_ENTRADA;
	
    @JsonCreator
    public static EnunTipoIngresso getByCodigo(String codigo) {
        return EnunTipoIngresso.valueOf(codigo);
    }
}
