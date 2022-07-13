package com.sergio.eduardo.resources;

import java.net.URI;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sergio.eduardo.dto.HospitalDTO;
import com.sergio.eduardo.services.HospitalService;

@RestController
@RequestMapping(value = "/hospital")
public class HospitalResource {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/paginacaoComSeisParametros")
	public ResponseEntity<Page<HospitalDTO>> findAllPageable(

			@RequestParam(value = "min", defaultValue = "") String min,
			@RequestParam(value = "max", defaultValue = "") String max,

			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction

	) {

		Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
		Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

		if (linesPerPage == 0) {
			linesPerPage = Integer.MAX_VALUE;
		}

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		Page<HospitalDTO> list = hospitalService.findByMoments(minDate, maxDate, pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<HospitalDTO> insert(@RequestBody HospitalDTO dto) {// A01.18
		dto = hospitalService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<HospitalDTO> update(@PathVariable Long id, @RequestBody HospitalDTO dto) {
		dto = hospitalService.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		hospitalService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping(value = "/{id}/findById")
	public ResponseEntity<HospitalDTO> findById(@PathVariable Long id) {
		HospitalDTO dto = hospitalService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{bairroDoHospital}/bairroDoHospitalIgnoreCase")
	public ResponseEntity<List<HospitalDTO>> findByBairro(
			@PathVariable String bairroDoHospital) {
		List<HospitalDTO> list = hospitalService.findByBairro(bairroDoHospital);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{nomeDoHospital}/nomeDoHospitalIgnoreCase")
	public ResponseEntity<List<HospitalDTO>> findByNome(
			@PathVariable String nomeDoHospital) {
		List<HospitalDTO> list = hospitalService.findByNome(nomeDoHospital);
		return ResponseEntity.ok().body(list);
	}
}
