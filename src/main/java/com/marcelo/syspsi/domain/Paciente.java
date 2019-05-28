package com.marcelo.syspsi.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Paciente extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "paciente")	
	List<Atendimento> consultas = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;	

	public Paciente() {		
	}

	public Paciente(Integer id, String nome, String email, String cpf, Date dataNascimento, Endereco endereco) {
		super(id, nome, email, cpf);
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}	

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public List<Atendimento> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Atendimento> consultas) {
		this.consultas = consultas;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
		
}
