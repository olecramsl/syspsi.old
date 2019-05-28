package com.marcelo.syspsi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Despesa;
import com.marcelo.syspsi.repositories.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repo;
	
	public Despesa buscar(Integer id) {
		Optional<Despesa> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
