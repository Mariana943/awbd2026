package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.FisaMedicala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru entitatea Fișă medicală
// Oferă operații de acces la baza de date pentru fișele medicale
@Repository
public interface FisaMedicalaRepository extends JpaRepository<FisaMedicala, Long> {
}