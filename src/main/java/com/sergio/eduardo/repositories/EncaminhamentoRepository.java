package com.sergio.eduardo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sergio.eduardo.entities.EncaminhamentoHospitalar;

@Repository
public interface EncaminhamentoRepository extends JpaRepository<EncaminhamentoHospitalar, Long> {

	@Query("SELECT DISTINCT obj FROM EncaminhamentoHospitalar obj "
			+ "ORDER BY obj.id ASC")
			List<EncaminhamentoHospitalar> findOrdersIdAsc();
}
