package com.marcelo.syspsi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Despesa;
import com.marcelo.syspsi.domain.dto.DespesaDTO;
import com.marcelo.syspsi.repositories.DespesaRepository;
import com.marcelo.syspsi.services.exception.DataIntegrityException;
import com.marcelo.syspsi.services.exception.ObjectNotFoundException;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repo;
	
	public Despesa find(Integer id) {
		Optional<Despesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Despesa.class.getName()));
	}

	public Despesa insert(Despesa obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Despesa update(Despesa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir a despesa, pois ela está associada a um atendimento.");
		}
	}

	public List<Despesa> findAll() {		
		return repo.findAll();
	}
	
	public Page<Despesa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);		
		return repo.findAll(pageRequest);
	}

	public Despesa fromDTO(DespesaDTO objDTO) {		
		return new Despesa(objDTO.getId(), objDTO.getTipo(), objDTO.getValor(), objDTO.getData());
	}
	
	
}
