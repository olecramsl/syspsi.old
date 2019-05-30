package com.marcelo.syspsi.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.domain.Despesa;
import com.marcelo.syspsi.domain.Endereco;
import com.marcelo.syspsi.domain.Paciente;
import com.marcelo.syspsi.domain.Psicologo;

public class AtendimentoDTO implements Serializable {		
	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data;
	@NotEmpty(message = "O prontuário deve ser informado.")
	private String prontuario;	
	@NotNull(message = "O valor deve ser informado.")
	private Double valor;
	
	@NotNull(message = "O psicólogo deve ser informado.")
	private Psicologo psicologo;
		
	@NotNull(message = "O paciente deve ser informado.")
	private Paciente paciente;
	
	@NotNull(message = "O endereço de atendimento deve ser informado.")
	private Endereco enderecoDoAtendimento;
	
	private List<Despesa> despesas = new ArrayList<>();
	
	public AtendimentoDTO() {		
	}
	
	public AtendimentoDTO(Atendimento obj) {
		this.id = obj.getId();
		this.data = obj.getData();
		this.prontuario = obj.getProntuario();
		this.valor = obj.getValor();
		this.psicologo = obj.getPsicologo();
		this.paciente = obj.getPaciente();
		this.enderecoDoAtendimento = obj.getEnderecoDoAtendimento();
		this.despesas = obj.getDespesas();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Psicologo getPsicologo() {
		return psicologo;
	}

	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Endereco getEnderecoDoAtendimento() {
		return enderecoDoAtendimento;
	}

	public void setEnderecoDoAtendimento(Endereco enderecoDoAtendimento) {
		this.enderecoDoAtendimento = enderecoDoAtendimento;
	}

	public List<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}	
}
