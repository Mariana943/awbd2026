package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Sectie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru entitatea Secției
// Oferă operații de acces la baza de date pentru secție
@Repository
public interface SectieRepository extends JpaRepository<Sectie, Long> {
}