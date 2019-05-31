package com.marcelo.syspsi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Paciente;
import com.marcelo.syspsi.domain.dto.PacienteDTO;
import com.marcelo.syspsi.repositories.PacienteRepository;
import com.marcelo.syspsi.services.exception.DataIntegrityException;
import com.marcelo.syspsi.services.exception.ObjectNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}

	public Paciente insert(Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Paciente update(Paciente obj) {
		Paciente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}		

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o paciente, pois ele está associado a outra tabela.");
		}
	}

	public List<Paciente> findAll() {		
		return repo.findAll();
	}
	
	public Page<Paciente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);		
		return repo.findAll(pageRequest);
	}

	public Paciente fromDTO(PacienteDTO objDTO) {		
		return new Paciente(null, objDTO.getNome(), objDTO.getEmail(), objDTO.getCpf(), 
				objDTO.getDataNascimento(), objDTO.getEndereco());
	}
	
	private void updateData(Paciente newObj, Paciente obj) {
		newObj.setNome(obj.getNome());				
		newObj.setEmail(obj.getEmail());				
		newObj.setCpf(obj.getCpf());		
		newObj.setDataNascimento(obj.getDataNascimento());		
		newObj.setEndereco(obj.getEndereco());		
	}
}
