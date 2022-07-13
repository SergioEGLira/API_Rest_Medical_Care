package com.sergio.eduardo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sergio.eduardo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
