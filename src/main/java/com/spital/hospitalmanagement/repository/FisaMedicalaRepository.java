package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.FisaMedicala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FisaMedicalaRepository extends JpaRepository<FisaMedicala, Long> {
}