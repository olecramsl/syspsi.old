package com.marcelo.syspsi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcelo.syspsi.domain.Paciente;
import com.marcelo.syspsi.repositories.PacienteRepository;
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
		find(obj.getId());		
		return repo.save(obj);
	}
}
