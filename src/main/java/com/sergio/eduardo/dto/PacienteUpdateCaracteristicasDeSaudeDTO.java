package com.sergio.eduardo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergio.eduardo.entities.GravidadeDaEnfermidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteUpdateCaracteristicasDeSaudeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long pacienteId;
	private String tipoSanguineo;
	private String enfermidade;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataDeInternamento;
	private String alaHospitalar;	
	@Enumerated(EnumType.STRING)
	private GravidadeDaEnfermidade gravidadeDaEnfermidade;	
	public PacienteUpdateCaracteristicasDeSaudeDTO() {
	}

	public PacienteUpdateCaracteristicasDeSaudeDTO(Long pacienteId, String tipoSanguineo, String enfermidade,
			Date dataDeInternamento, String alaHospitalar, GravidadeDaEnfermidade gravidadeDaEnfermidade) {

		this.pacienteId = pacienteId;
		this.tipoSanguineo = tipoSanguineo;
		this.enfermidade = enfermidade;
		this.dataDeInternamento = dataDeInternamento;
		this.alaHospitalar = alaHospitalar;
		this.gravidadeDaEnfermidade = gravidadeDaEnfermidade;
	}

}
