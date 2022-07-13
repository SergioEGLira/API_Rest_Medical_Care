package com.sergio.eduardo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sergio.eduardo.entities.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Paciente findByCpf(String cpf);

	List<Paciente> findByNomeContainingIgnoreCase(String name);

	@Query("SELECT DISTINCT obj FROM Paciente obj "
			+ "WHERE obj.gravidadeDaEnfermidade = 'GRAVE' ORDER BY obj.nome ASC")
	List<Paciente> findOrdersGraveNomeAsc();

}
