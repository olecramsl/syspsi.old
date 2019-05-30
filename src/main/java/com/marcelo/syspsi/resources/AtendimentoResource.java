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

import com.marcelo.syspsi.domain.Atendimento;
import com.marcelo.syspsi.domain.dto.AtendimentoDTO;
import com.marcelo.syspsi.services.AtendimentoService;

@RestController
@RequestMapping(value="/atendimentos")
public class AtendimentoResource {

	@Autowired
	private AtendimentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AtendimentoDTO> find(@PathVariable Integer id) {
		AtendimentoDTO objDTO = new AtendimentoDTO(service.find(id));
				
		return ResponseEntity.ok().body(objDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AtendimentoDTO objDTO) {		
		Atendimento obj = service.fromDTO(objDTO);
		obj.setId(null);
		obj = service.insert(obj);
				
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AtendimentoDTO objDTO, @PathVariable Integer id) {
		Atendimento obj = service.fromDTO(objDTO);
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
	public ResponseEntity<List<AtendimentoDTO>> findAll() {
		List<Atendimento> list = service.findAll();
		List<AtendimentoDTO> listDTO = list.stream().map(obj -> new AtendimentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AtendimentoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "paciente.nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page <Atendimento> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AtendimentoDTO> listDTO = list.map(obj -> new AtendimentoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
