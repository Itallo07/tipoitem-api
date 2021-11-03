package com.itallo.tipoitem.resources;

import java.net.URI;
import java.util.List;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itallo.tipoitem.domain.tipoItem;
import com.itallo.tipoitem.dtos.tipoItemDTO;
import com.itallo.tipoitem.service.tipoItemService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tipoitens")
public class tipoItemResources {
	@Autowired
	private tipoItemService tipoItemService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<tipoItem> findById(@PathVariable Integer id) {
		tipoItem obj = tipoItemService.findById(id);

		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<tipoItemDTO>> findAll() {
		List<tipoItem> list = tipoItemService.findAll();

		List<tipoItemDTO> listDTO = list.stream().map(obj -> new tipoItemDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping	
	public ResponseEntity<tipoItem> create(@Valid @RequestBody tipoItem obj) { 
		obj = tipoItemService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<tipoItemDTO> update(@PathVariable Integer id,@Valid @RequestBody tipoItemDTO objDTO){
		tipoItem newObj = tipoItemService.update(id, objDTO);
		
		return ResponseEntity.ok(new tipoItemDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		tipoItemService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
