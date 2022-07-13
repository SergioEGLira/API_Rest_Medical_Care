package com.sergio.eduardo.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sergio.eduardo.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

	@Query("SELECT obj FROM Hospital obj WHERE "
			+ "(coalesce(:min, null) IS NULL OR obj.moment >= :min) " + "AND "
			+ "(coalesce(:max, null) IS NULL OR obj.moment <= :max)")
	Page<Hospital> findByMoments(Instant min, Instant max, Pageable pageable);

	
	List<Hospital> findByBairroDoHospitalContainingIgnoreCase(String bairroDoHospital);
	
	List<Hospital> findByNomeDoHospitalContainingIgnoreCase(String nomeDoHospital);
}
