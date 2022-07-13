package com.sergio.eduardo.resources;

import java.util.List;

import javax.validation.Valid;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sergio.eduardo.dto.PacienteDTO;
import com.sergio.eduardo.dto.PacienteEntityDTO;
import com.sergio.eduardo.dto.PacienteUpdateCaracteristicasDeCadastroDTO;
import com.sergio.eduardo.dto.PacienteUpdateCaracteristicasDeSaudeDTO;
import com.sergio.eduardo.entities.Paciente;
import com.sergio.eduardo.services.PacienteService;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteResource {

	@Autowired
	private ViaCepOpenFeignResource viaCepService;

	@Autowired
	private PacienteService pacienteService;

	@PostMapping
	public ResponseEntity<Paciente> postViaCepFeign(@Valid @RequestBody PacienteDTO dto)
			throws JsonProcessingException {

		Paciente paciente = viaCepService.obterCep(dto.getCep());
		paciente.setComplemento(dto.getComplemento());
		paciente.setNumero(dto.getNumero());
		paciente.setNome(dto.getNome());
		paciente.setEmail(dto.getEmail());
		paciente.setDataDeNascimento(dto.getDataDeNascimento());
		paciente.setCpf(dto.getCpf());
		paciente.setIdade(dto.getIdade());
		paciente.setTipoSanguineo(dto.getTipoSanguineo());
		paciente.setEnfermidade(dto.getEnfermidade());
		paciente.setDataDeInternamento(dto.getDataDeInternamento());
		paciente.setAlaHospitalar(dto.getAlaHospitalar());
		paciente.setGravidadeDaEnfermidade(dto.getGravidadeDaEnfermidade());
		pacienteService.save(paciente);
		return ResponseEntity.ok(paciente);
	}

	@PutMapping(value = "/{id}/caracteristicasDeSaude")
	public ResponseEntity<PacienteUpdateCaracteristicasDeSaudeDTO> updateCaracteristicasDeSaude(@PathVariable Long id,
			@RequestBody PacienteUpdateCaracteristicasDeSaudeDTO dto) {
		dto = pacienteService.updateCaracteristicasDeSaude(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@PutMapping(value = "/{id}/caracteristicasDeCadastro")
	public ResponseEntity<PacienteUpdateCaracteristicasDeCadastroDTO> updateCaracteristicasDeCadastro(
			@PathVariable Long id, @RequestBody PacienteUpdateCaracteristicasDeCadastroDTO dto) {
		dto = pacienteService.updateCaracteristicasDeCadastro(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{id}/findById")
	public ResponseEntity<PacienteEntityDTO> findById(@PathVariable Long id) {
		PacienteEntityDTO dto = pacienteService.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@GetMapping(value = "/{cpf}/findByCpf")
	public ResponseEntity<Paciente> buscar(@PathVariable String cpf) {
		Paciente obj = pacienteService.findCPF(cpf);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/{name}/nameIgnoreCase")
	public ResponseEntity<List<PacienteEntityDTO>> findByPartesDoNome(@PathVariable String name) {
		List<PacienteEntityDTO> list = pacienteService.findByName(name);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/somentePacientesGravesnameAsc")
	public ResponseEntity<List<PacienteEntityDTO>> findAll() {
		List<PacienteEntityDTO> list = pacienteService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/paginacao")
	public ResponseEntity<Page<PacienteEntityDTO>> findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Page<PacienteEntityDTO> list = pacienteService.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pacienteService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
