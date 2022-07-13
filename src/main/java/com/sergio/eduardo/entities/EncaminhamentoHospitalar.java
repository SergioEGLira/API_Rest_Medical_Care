package com.sergio.eduardo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_solicitacao")
public class EncaminhamentoHospitalar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;

	@JsonIgnore
	@ManyToMany
	@Setter(AccessLevel.NONE)
	@JoinTable(name = "tb_encaminhamento_hospital", 
		joinColumns = @JoinColumn(name = "encaminhamento_id"), 
		inverseJoinColumns = @JoinColumn(name = "hospital_id"))
	private List<Hospital> hospital = new ArrayList<>();

	public EncaminhamentoHospitalar() {

	}

	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;

	public EncaminhamentoHospitalar(Long id, Instant moment, Paciente paciente) {

		this.id = id;
		this.moment = moment;
		this.paciente = paciente;
	}

}
