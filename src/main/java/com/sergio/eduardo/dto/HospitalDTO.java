package com.sergio.eduardo.dto;

import java.io.Serializable;
import java.time.Instant;

import com.sergio.eduardo.entities.Hospital;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HospitalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nomeDoHospital;

	private String enderecoDoHospital;
	private String bairroDoHospital;
	private String cepDoHospital;
	private String telefoneDoHospital;

	private Instant moment;

	public HospitalDTO() {

	}

	public HospitalDTO(Long id, String nomeDoHospital, String enderecoDoHospital, String bairroDoHospital,
			String cepDoHospital, String telefoneDoHospital, Instant moment) {
		this.id = id;
		this.nomeDoHospital = nomeDoHospital;
		this.enderecoDoHospital = enderecoDoHospital;
		this.bairroDoHospital = bairroDoHospital;
		this.cepDoHospital = cepDoHospital;
		this.telefoneDoHospital = telefoneDoHospital;
		this.moment = moment;
	}

	public HospitalDTO(Hospital entity) {

		id = entity.getId();
		nomeDoHospital = entity.getNomeDoHospital();
		enderecoDoHospital = entity.getEnderecoDoHospital();
		bairroDoHospital = entity.getBairroDoHospital();
		cepDoHospital = entity.getCepDoHospital();
		telefoneDoHospital = entity.getTelefoneDoHospital();
		moment = entity.getMoment();
	}

}
