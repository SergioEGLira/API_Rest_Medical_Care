package com.sergio.eduardo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergio.eduardo.entities.GravidadeDaEnfermidade;
import com.sergio.eduardo.entities.Paciente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteEntityDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String email;
	private String logradouro;
	private String complemento;
	private Long numero;
	private String bairro;
	private String localidade;
	private String uf;
	private String cep;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataDeNascimento;
	private int idade;
	private String tipoSanguineo;
	private String enfermidade;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataDeInternamento;
	private String alaHospitalar;	
	@Enumerated(EnumType.STRING)
	private GravidadeDaEnfermidade gravidadeDaEnfermidade; 

	public PacienteEntityDTO() {
	}

	public PacienteEntityDTO(Paciente entity) {

		cep = entity.getCep();
		numero = entity.getNumero();
		complemento = entity.getComplemento();
		nome = entity.getNome();
		logradouro = entity.getLogradouro();
		bairro = entity.getBairro();
		localidade = entity.getLocalidade();
		uf = entity.getUf();
		email = entity.getEmail();
		cpf = entity.getCpf();
		dataDeNascimento = entity.getDataDeNascimento();
		idade = entity.getIdade();
		tipoSanguineo = entity.getTipoSanguineo();
		enfermidade = entity.getEnfermidade();
		dataDeInternamento = entity.getDataDeInternamento();
		alaHospitalar = entity.getAlaHospitalar();		
		gravidadeDaEnfermidade = entity.getGravidadeDaEnfermidade();
	}

}
