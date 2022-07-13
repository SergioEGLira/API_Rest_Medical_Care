package com.sergio.eduardo.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteUpdateCaracteristicasDeCadastroDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long pacienteId;

	private String nome;
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

	public PacienteUpdateCaracteristicasDeCadastroDTO() {
	}

	public PacienteUpdateCaracteristicasDeCadastroDTO(Long pacienteId, String nome, Date dataDeNascimento,
			String logradouro, Long numero, String complemento, String bairro, String localidade, String uf, String cep,
			int idade) {
		this.pacienteId = pacienteId;
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
		this.idade = idade;
	}

}
