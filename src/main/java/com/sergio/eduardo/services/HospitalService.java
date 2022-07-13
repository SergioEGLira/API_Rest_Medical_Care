package com.sergio.eduardo.services;

import java.time.Instant;
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

import com.sergio.eduardo.dto.HospitalDTO;
import com.sergio.eduardo.entities.Hospital;
import com.sergio.eduardo.repositories.HospitalRepository;
import com.sergio.eduardo.services.exceptions.DatabaseException;
import com.sergio.eduardo.services.exceptions.ResourceNotFoundException;

@Service
public class HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Transactional(readOnly = true)
	public Page<HospitalDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {

		return hospitalRepository.findByMoments(minDate, maxDate, pageRequest).map(x -> new HospitalDTO(x));
	}

	@Transactional
	public HospitalDTO insert(HospitalDTO dto) {
		Hospital entity = new Hospital();

		entity.setNomeDoHospital(dto.getNomeDoHospital());
		entity.setEnderecoDoHospital(dto.getEnderecoDoHospital());
		entity.setBairroDoHospital(dto.getBairroDoHospital());
		entity.setCepDoHospital(dto.getCepDoHospital());
		entity.setTelefoneDoHospital(dto.getTelefoneDoHospital());
		entity.setMoment(Instant.now());

		entity = hospitalRepository.save(entity);
		return new HospitalDTO(entity);
	}

	@Transactional
	public HospitalDTO update(Long id, HospitalDTO dto) {
		try {
			Hospital entity = hospitalRepository.getOne(id);

			entity.setNomeDoHospital(dto.getNomeDoHospital());
			entity.setEnderecoDoHospital(dto.getEnderecoDoHospital());
			entity.setBairroDoHospital(dto.getBairroDoHospital());
			entity.setCepDoHospital(dto.getCepDoHospital());
			entity.setTelefoneDoHospital(dto.getTelefoneDoHospital());

			return new HospitalDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Não encontramos o id " + id);
		}
	}

	public void delete(Long id) {
		try {
			hospitalRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Não encontramos o id " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro de integridade do bco de dados!");
		}
	}

	@Transactional(readOnly = true)
	public HospitalDTO findById(Long id) {
		Optional<Hospital> obj = hospitalRepository.findById(id);
		Hospital entity = obj.orElseThrow(() -> new ResourceNotFoundException("Não encontramos a entidade"));
		return new HospitalDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<HospitalDTO> findByBairro(String bairroDoHospital) {
		List<Hospital> list = hospitalRepository.findByBairroDoHospitalContainingIgnoreCase(bairroDoHospital);
		if (list.size() == 0) {
			throw new EntityNotFoundException();
		} else {
			return list.stream().map(x -> new HospitalDTO(x)).collect(Collectors.toList());
		}

	}
	
	@Transactional(readOnly = true)
	public List<HospitalDTO> findByNome(String nomeDoHospital) {
		List<Hospital> list = hospitalRepository.findByNomeDoHospitalContainingIgnoreCase(nomeDoHospital);
		if (list.size() == 0) {
			throw new EntityNotFoundException();
		} else {
			return list.stream().map(x -> new HospitalDTO(x)).collect(Collectors.toList());
		}

	}
}
