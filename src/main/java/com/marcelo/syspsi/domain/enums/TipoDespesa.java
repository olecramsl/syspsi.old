package com.marcelo.syspsi.domain.enums;

public enum TipoDespesa {
	AUGUELSALA(0, "Aluguel de Sala"),
	TRANSPORTE(1, "Transporte"),
	ALIMENTACAO(2, "Alimentação"),
	ENERGIAELETRICA(3, "Energia Elétrica"),
	AGUA(4, "Água"),
	CONDOMINIO(5, "Condomínio"),
	OUTRAS(6, "Outras despesas");
	
	private int cod;
	private String descricao;
	
	private TipoDespesa(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}	
	
	public static TipoDespesa toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for (TipoDespesa x : TipoDespesa.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
	}
}
