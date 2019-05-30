package com.marcelo.syspsi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcelo.syspsi.domain.Psicologo;
import com.marcelo.syspsi.domain.dto.PsicologoDTO;
import com.marcelo.syspsi.services.PsicologoService;

@RestController
@RequestMapping(value="/psicologos")
public class PsicologoResource {

	@Autowired
	private PsicologoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<PsicologoDTO> find(@PathVariable Integer id) {		
		PsicologoDTO objDTO = new PsicologoDTO(service.find(id));
				
		return ResponseEntity.ok().body(objDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PsicologoDTO objDTO) {
		Psicologo obj = service.fromDTO(objDTO);
		obj.setId(null);
		obj = service.insert(obj);
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PsicologoDTO objDTO, @PathVariable Integer id) {
		Psicologo obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
				
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {		
		service.delete(id);				
				
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PsicologoDTO>> findAll() {
		List<Psicologo> list = service.findAll();
		List<PsicologoDTO> listDTO = list.stream().map(obj -> new PsicologoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PsicologoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page <Psicologo> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PsicologoDTO> listDTO = list.map(obj -> new PsicologoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
