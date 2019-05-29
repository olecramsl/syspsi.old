package com.marcelo.syspsi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.repositories.AtendimentoRepository;
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
}
