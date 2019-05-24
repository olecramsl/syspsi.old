package com.marcelo.syspsi.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Paciente extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	public Paciente() {		
	}

	public Paciente(Integer id, String nome, String email, Date dataNascimento) {
		super(id, nome, email);
		this.dataNascimento = dataNascimento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	
}
