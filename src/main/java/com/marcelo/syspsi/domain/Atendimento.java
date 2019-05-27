package com.marcelo.syspsi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Atendimento implements Serializable {		
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private String prontuario;
	private Double valor;
	
	@ManyToOne
	@JoinColumn(name = "psicologo_id")
	private Psicologo psicologo;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name = "endereco_atendimento_id")
	private Endereco enderecoDoAtendimento;
	
	public Atendimento() {		
	}

	public Atendimento(Integer id, Date data, String prontuario, Double valor, Psicologo psicologo, Paciente paciente,
			Endereco enderecoDoAtendimento) {
		super();
		this.id = id;
		this.data = data;
		this.prontuario = prontuario;
		this.valor = valor;
		this.psicologo = psicologo;
		this.paciente = paciente;
		this.enderecoDoAtendimento = enderecoDoAtendimento;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atendimento other = (Atendimento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}
