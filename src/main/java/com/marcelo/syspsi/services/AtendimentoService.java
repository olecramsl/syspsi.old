package com.marcelo.syspsi.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.domain.dto.AtendimentoDTO;
import com.marcelo.syspsi.repositories.AtendimentoRepository;
import com.marcelo.syspsi.services.exception.DataIntegrityException;
import com.marcelo.syspsi.services.exception.ObjectNotFoundException;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository repo;
	
	public Atendimento find(Integer id) {
		Optional<Atendimento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Atendimento.class.getName()));
	}
	
	public Atendimento insert(Atendimento obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Atendimento update(Atendimento obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um atendimento que possui psicólogos e pacientes");
		}
	}

	public List<Atendimento> findAll() {		
		return repo.findAll();
	}
	
	public Page<Atendimento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Atendimento fromDTO(@Valid AtendimentoDTO objDTO) {		
		return new Atendimento(objDTO.getId(), objDTO.getData(), objDTO.getProntuario(), objDTO.getValor(), 
				objDTO.getPsicologo(), objDTO.getPaciente(), objDTO.getEnderecoDoAtendimento());
	}	
}
