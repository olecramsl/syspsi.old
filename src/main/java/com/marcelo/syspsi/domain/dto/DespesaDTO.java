package com.marcelo.syspsi.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.marcelo.syspsi.domain.Despesa;
import com.marcelo.syspsi.domain.enums.TipoDespesa;

public class DespesaDTO implements Serializable {		
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotNull(message = "O tipo da despesa deve ser informado.")	
	private TipoDespesa tipo;
	@NotNull(message = "O valor da despesa deve ser informado.")
	private Double valor;
	@NotNull(message = "A data da despesa deve ser informada.")
	private Date data;
	
	public DespesaDTO() {		
	}

	public DespesaDTO(Despesa obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.valor = obj.getValor();
		this.data = obj.getData();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDespesa getTipo() {
		return tipo;
	}

	public void setTipo(TipoDespesa tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}		
}
