package com.marcelo.syspsi.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.services.AtendimentoService;

@RestController
@RequestMapping(value="/atendimentos")
public class AtendimentoResource {

	@Autowired
	private AtendimentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Atendimento> find(@PathVariable Integer id) {
		Atendimento obj = service.find(id);
				
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Atendimento obj) {
		obj = service.insert(obj);
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Atendimento obj, @PathVariable Integer id) {		
		obj.setId(id);
		obj = service.update(obj);
				
		return ResponseEntity.noContent().build();
	}
}
