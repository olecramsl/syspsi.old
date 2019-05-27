package com.marcelo.syspsi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Psicologo extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String crp;
	
	@OneToMany(mappedBy = "psicologo")	
	private List<Atendimento> atendimentos = new ArrayList<>();
			
	public Psicologo() {		
	}

	public Psicologo(Integer id, String nome, String email, String cpf, String crp) {
		super(id, nome, email, cpf);
		this.crp = crp;
	}

	public String getCrp() {
		return crp;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}	
}
