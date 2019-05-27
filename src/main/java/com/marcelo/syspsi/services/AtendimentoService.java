package com.marcelo.syspsi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository repo;
	
	public Atendimento buscar(Integer id) {
		Optional<Atendimento> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
