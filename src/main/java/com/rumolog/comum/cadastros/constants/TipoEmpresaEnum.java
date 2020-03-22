package com.rumolog.comum.cadastros.constants;

public enum TipoEmpresaEnum {
	
	INTERNO("I"),
    
    CLIENTE("C"),
    
    FERROVIA("F");
	
	private final String chave;
	
	private TipoEmpresaEnum(String chave) {
		this.chave = chave;
	}

	public String getChave() {
		return chave;
	}
	
	public static TipoEmpresaEnum getPorChave(String chave) {
		for (TipoEmpresaEnum b : TipoEmpresaEnum.values()) {
			if (String.valueOf(b.getChave()).equals(chave)) {
				return b;
			}
		}
		return null;
	}

}
