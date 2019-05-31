package com.marcelo.syspsi.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marcelo.syspsi.domain.Endereco;
import com.marcelo.syspsi.domain.Paciente;

public class PacienteDTO implements Serializable {		
	private static final long serialVersionUID = 1L;
			
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(max = 120, message = "O tamanho não pode ser maior que 120 caracteres.")
	private String nome;
	
	@Email(message = "O endereço de e-mail informado é inválido.")
	private String email;
		
	@Length(min = 11, max = 11, message = "O tamanho deve ser de 11 caracteres.")
	private String cpf;
	
	@NotNull(message = "Preenchimento obrigatório.")
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private Endereco endereco;
	
	public PacienteDTO() {		
	}
	
	public PacienteDTO(Paciente obj) {	
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();
		this.dataNascimento = obj.getDataNascimento();
		this.setEndereco(obj.getEndereco());
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
