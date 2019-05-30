package com.marcelo.syspsi.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.marcelo.syspsi.domain.Endereco;

public class EnderecoDTO implements Serializable {		
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "O campo deve ser preenchido.")
	private String logradouro;
	@NotEmpty(message = "O campo deve ser preenchido.")
	private String numero;
	private String complemento;
	@NotEmpty(message = "O campo deve ser preenchido.")
	private String bairro;
	@NotEmpty(message = "O campo deve ser preenchido.")
	@Pattern(regexp = "[0-9]{5}-[\\d]{3}", message = "O formato do campo CEP deve ser xxxxx-xxx")
	private String cep;
	@NotEmpty(message = "O campo deve ser preenchido.")
	private String cidade;
	@NotEmpty(message = "O campo deve ser preenchido.")
	private String estado;
	
	public EnderecoDTO() {		
	}
	
	public EnderecoDTO(Endereco obj) {
		this.id = obj.getId();
		this.logradouro = obj.getLogradouro();
		this.numero = obj.getNumero();
		this.complemento = obj.getComplemento();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
}
