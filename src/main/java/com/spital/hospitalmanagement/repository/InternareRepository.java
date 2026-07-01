package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Internare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru entitatea Internare
// Oferă operații de acces la baza de date pentru internare
@Repository
public interface InternareRepository extends JpaRepository<Internare, Long> {
}