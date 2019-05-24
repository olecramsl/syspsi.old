package com.marcelo.syspsi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Psicologo extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String crp;
	
	@OneToMany
	@JoinColumn(name = "psicologo_id")
	private List<Endereco> enderecosDeAtendimento = new ArrayList<>();
	
	public Psicologo() {		
	}

	public Psicologo(Integer id, String nome, String email, String crp) {
		super(id, nome, email);
		this.crp = crp;
	}

	public String getCrp() {
		return crp;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	public List<Endereco> getEnderecosDeAtendimento() {
		return enderecosDeAtendimento;
	}

	public void setEnderecosDeAtendimento(List<Endereco> enderecosDeAtendimento) {
		this.enderecosDeAtendimento = enderecosDeAtendimento;
	}		
}
