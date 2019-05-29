package com.marcelo.syspsi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Despesa;
import com.marcelo.syspsi.repositories.DespesaRepository;
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
	
	
}
