package com.sergio.eduardo.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sergio.eduardo.dto.EncaminhamentoHospitalarDTO;
import com.sergio.eduardo.dto.HospitalDTO;
import com.sergio.eduardo.entities.EncaminhamentoHospitalar;
import com.sergio.eduardo.entities.Hospital;
import com.sergio.eduardo.entities.Paciente;
import com.sergio.eduardo.repositories.EncaminhamentoRepository;
import com.sergio.eduardo.repositories.HospitalRepository;
import com.sergio.eduardo.repositories.PacienteRepository;
import com.sergio.eduardo.services.exceptions.ResourceNotFoundException;

@Service
public class EncaminhamentoService {

	@Autowired
	private EncaminhamentoRepository encaminhamentoRepository;

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Transactional
	public EncaminhamentoHospitalarDTO insert(EncaminhamentoHospitalarDTO dto) {

		EncaminhamentoHospitalar encaminhamento = new EncaminhamentoHospitalar();

		encaminhamento.setMoment(Instant.now());

		Paciente paciente = pacienteRepository.getOne(dto.getPacienteId());
		encaminhamento.setPaciente(paciente);

		for (HospitalDTO p : dto.getHospital()) {
			Hospital hospital = hospitalRepository.getOne(p.getId());
			encaminhamento.getHospital().add(hospital);
		}

		encaminhamento = encaminhamentoRepository.save(encaminhamento);
		return new EncaminhamentoHospitalarDTO(encaminhamento);
	}
	
	@Transactional(readOnly = true)
	public List<EncaminhamentoHospitalarDTO> findAll(){
		List<EncaminhamentoHospitalar> list = encaminhamentoRepository.findOrdersIdAsc();
		return list.stream().map(x-> new EncaminhamentoHospitalarDTO(x)).collect(Collectors.toList());
	}
		
	@Transactional(readOnly = true)
	public EncaminhamentoHospitalarDTO findById(Long id) { 
		Optional<EncaminhamentoHospitalar> obj = encaminhamentoRepository.findById(id);
		EncaminhamentoHospitalar entity = obj
										.orElseThrow(
										() -> new ResourceNotFoundException("Não encontramos a entidade")
										);
		return new EncaminhamentoHospitalarDTO(entity);
	}
		
}
