package br.com.edward.restfull.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnumTipoIngresso {
	
	INTEIRA,
	MEIA_ENTRADA;
	
    @JsonCreator
    public static EnumTipoIngresso getByCodigo(String codigo) {
        return EnumTipoIngresso.valueOf(codigo);
    }
}
