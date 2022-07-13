package com.sergio.eduardo.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sergio.eduardo.dto.EncaminhamentoHospitalarDTO;
import com.sergio.eduardo.services.EncaminhamentoService;

@RestController
@RequestMapping(value = "/encaminhamentoHospitalar")
public class EncaminhamentoResource {

	@Autowired
	private EncaminhamentoService encaminhamentoService;
	
	@PostMapping
	public ResponseEntity<EncaminhamentoHospitalarDTO> insert(@Valid @RequestBody EncaminhamentoHospitalarDTO dto){ 
		dto = encaminhamentoService.insert(dto);
		
		URI uri = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(dto.getId())
						.toUri();
		
		return ResponseEntity
				.created(uri)
				.body(dto);		
	}	
			
	@GetMapping("/Encaminhamento")
		public ResponseEntity<List<EncaminhamentoHospitalarDTO>> findAll() { 
		List<EncaminhamentoHospitalarDTO> list = encaminhamentoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}/findById")
	public ResponseEntity<EncaminhamentoHospitalarDTO> findById(@PathVariable Long id) {
		EncaminhamentoHospitalarDTO dto = encaminhamentoService.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
