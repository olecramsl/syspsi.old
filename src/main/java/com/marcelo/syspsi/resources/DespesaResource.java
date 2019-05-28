package com.marcelo.syspsi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.syspsi.domain.Despesa;
import com.marcelo.syspsi.services.DespesaService;

@RestController
@RequestMapping(value="/despesas")
public class DespesaResource {

	@Autowired
	private DespesaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Despesa obj = service.buscar(id);
				
		return ResponseEntity.ok().body(obj);
	}
}
