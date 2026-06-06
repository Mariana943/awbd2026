package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Sectie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectieRepository extends JpaRepository<Sectie, Long> {
}