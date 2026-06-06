package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Consultatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultatieRepository extends JpaRepository<Consultatie, Long> {
}