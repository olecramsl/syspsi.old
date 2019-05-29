package com.marcelo.syspsi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.services.AtendimentoService;

@RestController
@RequestMapping(value="/atendimentos")
public class AtendimentoResource {

	@Autowired
	private AtendimentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Atendimento> find(@PathVariable Integer id) {
		Atendimento obj = service.buscar(id);
				
		return ResponseEntity.ok().body(obj);
	}
}
