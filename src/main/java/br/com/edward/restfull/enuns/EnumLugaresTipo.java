package br.com.edward.restfull.enuns;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnumLugaresTipo {
	
	ESPECIAL,
	NORMAL,
	CASAL;
	
	@JsonCreator
    public static EnumLugaresTipo getByCodigo(String codigo) {
        return EnumLugaresTipo.valueOf(codigo);
    }
}
