package com.marcelo.syspsi.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Psicologo extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	private String crp;
	
	@OneToMany(mappedBy = "psicologo")	
	private List<Atendimento> atendimentos = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name="psicologo_enderecos_atendimento", joinColumns=
    {@JoinColumn(name="psicologo_id")}, inverseJoinColumns=
     {@JoinColumn(name="endereco_de_atendimento_id")})
	private List<Endereco> enderecosDeAtendimento = new ArrayList<>();
			
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

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public List<Endereco> getEnderecosDeAtendimento() {
		return enderecosDeAtendimento;
	}

	public void setEnderecosDeAtendimento(List<Endereco> enderecosDeAtendimento) {
		this.enderecosDeAtendimento = enderecosDeAtendimento;
	}	
}
