package com.marcelo.syspsi.domain;

import javax.persistence.Entity;

@Entity
public class Psicologo extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String crp;
	
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
}
