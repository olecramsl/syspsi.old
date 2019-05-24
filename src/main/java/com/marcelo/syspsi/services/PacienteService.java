package com.marcelo.syspsi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Paciente;
import com.marcelo.syspsi.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	public Paciente buscar(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
