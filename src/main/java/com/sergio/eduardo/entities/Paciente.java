package com.sergio.eduardo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_paciente")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true, length = 50) // TODO Unique email
	private String email;
	@Column(unique = true) // TODO Unique cpf
	private String cpf;
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
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	@JsonIgnore
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "paciente")
	private List<EncaminhamentoHospitalar> encaminhamento = new ArrayList<>();

	public Paciente() {
	}

	public Paciente(Long id, String nome, String email, String cpf, Date dataDeNascimento, String logradouro,
			Long numero, String complemento, String bairro, String localidade, String uf, String cep, int idade,
			String tipoSanguineo, String enfermidade, Date dataDeInternamento, String alaHospitalar,
			GravidadeDaEnfermidade gravidadeDaEnfermidade) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.cep = cep;
		this.idade = idade;
		this.tipoSanguineo = tipoSanguineo;
		this.enfermidade = enfermidade;
		this.dataDeInternamento = dataDeInternamento;
		this.alaHospitalar = alaHospitalar;
		this.gravidadeDaEnfermidade = gravidadeDaEnfermidade;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}
}
