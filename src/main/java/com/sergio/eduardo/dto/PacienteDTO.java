package com.sergio.eduardo.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sergio.eduardo.entities.GravidadeDaEnfermidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "O cep precisa ser preenchido...")
	@Size(min = 9, max = 9, message = " O Cep deve ter 9 caracteres, sendo sim necessário incluir no código postal o '-' (hífen)")
	private String cep;
	@Positive
	private Long numero;
	@NotBlank(message = "O complemento precisa ser preenchido...")
	@Size(max = 20, message = "Campo complemento deve ter no máximo 20 caracteres")
	private String complemento;
	@NotBlank(message = "Nome deixar espaços em branco...")
	@Size(min = 3, max = 30, message = "Deve ter entre 3 e 30 caracteres")
	private String nome;
	@NotBlank(message = "Email não pode ser vazio")
	@Email(message = "Favor entrar um email válido")
	private String email;
	@NotBlank(message = "CPF não pode ser vazio")
	@CPF(message = "Favor entrar um CPF válido")
	private String cpf;
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

	public PacienteDTO() {
	}

	public PacienteDTO(String cep, Long numero, String complemento, String nome, String email, String cpf,
			Date dataDeNascimento, int idade, String tipoSanguineo, String enfermidade, Date dataDeInternamento,
			String alaHospitalar, GravidadeDaEnfermidade gravidadeDaEnfermidade) {
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.idade = idade;
		this.tipoSanguineo = tipoSanguineo;
		this.enfermidade = enfermidade;
		this.dataDeInternamento = dataDeInternamento;
		this.alaHospitalar = alaHospitalar;
		this.gravidadeDaEnfermidade = gravidadeDaEnfermidade;
	}

}
