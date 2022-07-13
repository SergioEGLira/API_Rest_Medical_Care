package com.sergio.eduardo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergio.eduardo.entities.EncaminhamentoHospitalar;
import com.sergio.eduardo.entities.GravidadeDaEnfermidade;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncaminhamentoHospitalarDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant moment;

	@Positive
	private Long pacienteId;
	private String nome;
	private String cpf;	
	private String email;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataDeNascimento;
	private String logradouro;
	private Long numero;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String cep;
	private int idade;
	private String tipoSanguineo;
	private String enfermidade;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataDeInternamento;
	private String alaHospitalar;	
	@Enumerated(EnumType.STRING)
	private GravidadeDaEnfermidade gravidadeDaEnfermidade; 

	@Setter(AccessLevel.NONE)
	private List<HospitalDTO> hospital = new ArrayList<>();

	public EncaminhamentoHospitalarDTO() {
	}

	public EncaminhamentoHospitalarDTO(Long id, Instant moment, Long pacienteId) {
		this.id = id;
		this.moment = moment;
		this.pacienteId = pacienteId;
	}

	public EncaminhamentoHospitalarDTO(EncaminhamentoHospitalar entity) {
		id = entity.getId();
		moment = entity.getMoment();
		pacienteId = entity.getPaciente().getId();
		nome = entity.getPaciente().getNome();
		cpf = entity.getPaciente().getCpf();		
		email = entity.getPaciente().getEmail();			
		dataDeNascimento = entity.getPaciente().getDataDeNascimento();
		logradouro = entity.getPaciente().getLogradouro();
		numero = entity.getPaciente().getNumero();
		complemento = entity.getPaciente().getComplemento();
		bairro = entity.getPaciente().getBairro();
		localidade = entity.getPaciente().getLocalidade();
		uf = entity.getPaciente().getUf();
		cep = entity.getPaciente().getCep();
		idade = entity.getPaciente().getIdade();
		tipoSanguineo = entity.getPaciente().getTipoSanguineo();
		enfermidade = entity.getPaciente().getEnfermidade();
		dataDeInternamento = entity.getPaciente().getDataDeInternamento();
		alaHospitalar = entity.getPaciente().getAlaHospitalar();
		gravidadeDaEnfermidade = entity.getPaciente().getGravidadeDaEnfermidade();

		hospital = entity.getHospital().stream().map(x -> new HospitalDTO(x)).collect(Collectors.toList());
	}

}
