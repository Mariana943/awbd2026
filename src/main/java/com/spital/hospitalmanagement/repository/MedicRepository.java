package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Medic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru entitatea Medic
// Oferă operații de acces la baza de date pentru medici
@Repository
public interface MedicRepository extends JpaRepository<Medic, Long> {
}