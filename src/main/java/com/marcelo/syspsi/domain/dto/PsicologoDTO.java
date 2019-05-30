package com.marcelo.syspsi.domain.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.marcelo.syspsi.domain.Endereco;
import com.marcelo.syspsi.domain.Psicologo;

public class PsicologoDTO implements Serializable {		
	private static final long serialVersionUID = 1L;
			
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(max = 80, message = "O tamanho não pode ser maior que 80 caracteres.")
	private String nome;
	
	@Email(message = "O endereço de e-mail informado é inválido.")
	private String email;
		
	@Length(min = 11, max = 11, message = "O tamanho deve ser de 11 caracteres.")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String crp;
	
	private Set<Endereco> enderecosDeAtendimento = new HashSet<>();
	
	private Set<String> telefones = new HashSet<>();
	
	public PsicologoDTO() {		
	}
	
	public PsicologoDTO(Psicologo obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();	
		this.crp = obj.getCrp();
		this.setEnderecosDeAtendimento(obj.getEnderecosDeAtendimento());
		this.setTelefones(obj.getTelefones());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}		
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}	

	public String getCrp() {
		return crp;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	public Set<Endereco> getEnderecosDeAtendimento() {
		return enderecosDeAtendimento;
	}

	public void setEnderecosDeAtendimento(Set<Endereco> enderecosDeAtendimento) {
		this.enderecosDeAtendimento = enderecosDeAtendimento;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
}
