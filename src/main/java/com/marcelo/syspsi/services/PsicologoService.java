package com.marcelo.syspsi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Psicologo;
import com.marcelo.syspsi.domain.dto.PsicologoDTO;
import com.marcelo.syspsi.repositories.PsicologoRepository;
import com.marcelo.syspsi.services.exception.DataIntegrityException;
import com.marcelo.syspsi.services.exception.ObjectNotFoundException;

@Service
public class PsicologoService {

	@Autowired
	private PsicologoRepository repo;
	
	public Psicologo find(Integer id) {
		Optional<Psicologo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Psicologo.class.getName()));
	}
	
	public Psicologo insert(Psicologo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Psicologo update(Psicologo obj) {
		Psicologo newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir o psicologo, pois ele está associado a outra tabela.");
		}
	}

	public List<Psicologo> findAll() {		
		return repo.findAll();
	}
	
	public Page<Psicologo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);		
		return repo.findAll(pageRequest);
	}

	public Psicologo fromDTO(PsicologoDTO objDTO) {		
		Psicologo obj = new Psicologo(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), objDTO.getCpf(), objDTO.getCrp());
		obj.setEnderecosDeAtendimento(objDTO.getEnderecosDeAtendimento());
		
		return obj;
	}
	
	private void updateData(Psicologo newObj, Psicologo obj) {
		newObj.setNome(obj.getNome());				
		newObj.setEmail(obj.getEmail());				
		newObj.setCpf(obj.getCpf());		
		newObj.setCrp(obj.getCrp());
		newObj.setEnderecosDeAtendimento(obj.getEnderecosDeAtendimento());
		newObj.setTelefones(obj.getTelefones());
	}
}
