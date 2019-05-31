package com.marcelo.syspsi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Endereco;
import com.marcelo.syspsi.domain.dto.EnderecoDTO;
import com.marcelo.syspsi.repositories.EnderecoRepository;
import com.marcelo.syspsi.services.exception.DataIntegrityException;
import com.marcelo.syspsi.services.exception.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repo;
	
	public Endereco find(Integer id) {
		Optional<Endereco> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}

	public Endereco insert(Endereco obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Endereco update(Endereco obj) {
		Endereco newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}		

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o endereco, pois ele está associado a uma pessoa.");
		}
	}

	public List<Endereco> findAll() {		
		return repo.findAll();
	}
	
	public Page<Endereco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);		
		return repo.findAll(pageRequest);
	}

	public Endereco fromDTO(EnderecoDTO objDTO) {		
		return new Endereco(objDTO.getId(), objDTO.getLogradouro(), objDTO.getNumero(), objDTO.getComplemento(), 
				objDTO.getBairro(), objDTO.getCep(), objDTO.getCidade(), objDTO.getEstado());
	}	
	
	private void updateData(Endereco newObj, Endereco obj) {
		newObj.setLogradouro(obj.getLogradouro());		
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());		
		newObj.setBairro(obj.getBairro());
		newObj.setCep(obj.getCep());
		newObj.setCidade(obj.getCidade());		
		newObj.setEstado(obj.getEstado());		
	}
}
