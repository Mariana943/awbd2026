package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Consultatie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru entitatea Consultației
// Oferă operații de acces la baza de date pentru consultații
@Repository
public interface ConsultatieRepository extends JpaRepository<Consultatie, Long> {
}