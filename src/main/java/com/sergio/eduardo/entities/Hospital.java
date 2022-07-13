package com.sergio.eduardo.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_hospital")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeDoHospital;
	private String enderecoDoHospital;
	private String bairroDoHospital;
	private String cepDoHospital;
	private String telefoneDoHospital;
	private Instant moment;	
	@Setter(AccessLevel.NONE)
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	@ManyToMany(mappedBy = "hospital")
	@Setter(AccessLevel.NONE)
	private List<EncaminhamentoHospitalar> encaminhamento = new ArrayList<>();

	public Hospital() {
		super();
	}

	public Hospital(Long id, String nomeDoHospital, String enderecoDoHospital, String bairroDoHospital,
			String cepDoHospital, String telefoneDoHospital, Instant moment) {
		this.id = id;
		this.nomeDoHospital = nomeDoHospital;
		this.enderecoDoHospital = enderecoDoHospital;
		this.bairroDoHospital = bairroDoHospital;
		this.cepDoHospital = cepDoHospital;
		this.telefoneDoHospital = telefoneDoHospital;
		this.moment = moment;
	}

	@PreUpdate
	public void preUpdate() {
		updatedAt = Instant.now();
	}

}
