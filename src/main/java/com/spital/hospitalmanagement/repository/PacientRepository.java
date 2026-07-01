package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Pacient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru accesul la datele pacienților
@Repository
public interface PacientRepository extends JpaRepository<Pacient, Long> {
}