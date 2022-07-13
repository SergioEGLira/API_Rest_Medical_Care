package com.sergio.eduardo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergio.eduardo.dto.PacienteEntityDTO;
import com.sergio.eduardo.dto.PacienteUpdateCaracteristicasDeCadastroDTO;
import com.sergio.eduardo.dto.PacienteUpdateCaracteristicasDeSaudeDTO;
import com.sergio.eduardo.entities.Paciente;
import com.sergio.eduardo.repositories.PacienteRepository;
import com.sergio.eduardo.services.exceptions.DatabaseException;
import com.sergio.eduardo.services.exceptions.ResourceNotFoundException;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public Paciente save(Paciente paciente) {
		pacienteRepository.save(paciente);
		return paciente;
	}

	@Transactional
	public PacienteUpdateCaracteristicasDeSaudeDTO updateCaracteristicasDeSaude(Long id,
			PacienteUpdateCaracteristicasDeSaudeDTO dto) {
		try {
			Paciente entity = pacienteRepository.getOne(id);

			dto.setPacienteId(id);
			entity.setTipoSanguineo(dto.getTipoSanguineo());
			entity.setEnfermidade(dto.getEnfermidade());
			entity.setDataDeInternamento(dto.getDataDeInternamento());
			entity.setAlaHospitalar(dto.getAlaHospitalar());
			entity.setGravidadeDaEnfermidade(dto.getGravidadeDaEnfermidade());

			entity = pacienteRepository.save(entity);
			return dto;

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Não encontramos o id " + id);
		}

	}

	@Transactional
	public PacienteUpdateCaracteristicasDeCadastroDTO updateCaracteristicasDeCadastro(Long id,
			PacienteUpdateCaracteristicasDeCadastroDTO dto) {
		try {
			Paciente entity = pacienteRepository.getOne(id);

			dto.setPacienteId(id);
			entity.setNome(dto.getNome());
			entity.setDataDeNascimento(dto.getDataDeNascimento());
			entity.setLogradouro(dto.getLogradouro());
			entity.setNumero(dto.getNumero());
			entity.setComplemento(dto.getComplemento());
			entity.setBairro(dto.getBairro());
			entity.setLocalidade(dto.getLocalidade());
			entity.setUf(dto.getUf());
			entity.setCep(dto.getCep());
			entity.setIdade(dto.getIdade());

			entity = pacienteRepository.save(entity);
			return dto;

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Não encontramos o id " + id);
		}

	}

	@Transactional(readOnly = true)
	public PacienteEntityDTO findById(Long id) {
		Optional<Paciente> obj = pacienteRepository.findById(id);
		Paciente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Não encontramos a entidade"));
		return new PacienteEntityDTO(entity);
	}

	public Paciente findCPF(String cpf) {
		Paciente obj = pacienteRepository.findByCpf(cpf);
		if (obj == null) {
			throw new EntityNotFoundException();
		}
		return obj;
	}

	@Transactional(readOnly = true)
	public List<PacienteEntityDTO> findByName(String name) {
		List<Paciente> list = pacienteRepository.findByNomeContainingIgnoreCase(name);
		if (list.size() == 0) {
			throw new EntityNotFoundException();
		} else {
			return list.stream().map(x -> new PacienteEntityDTO(x)).collect(Collectors.toList());
		}
	}

	@Transactional(readOnly = true)
	public List<PacienteEntityDTO> findAll() {
		List<Paciente> list = pacienteRepository.findOrdersGraveNomeAsc();
		return list.stream().map(x -> new PacienteEntityDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Page<PacienteEntityDTO> findAllPaged(PageRequest pageRequest) {
		Page<Paciente> list = pacienteRepository.findAll(pageRequest);
		return list.map(x -> new PacienteEntityDTO(x));
	}

	public void delete(Long id) {
		try {
			pacienteRepository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não encontramos o id " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro de integridade do bco de dados!");
		}
	}
}
