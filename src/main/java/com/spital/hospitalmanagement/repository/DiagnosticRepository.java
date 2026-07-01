package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Diagnostic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru entitatea Diagnostic
// Oferă operații de acces la baza de date pentru diagnostice
@Repository
public interface DiagnosticRepository extends JpaRepository<Diagnostic, Long> {
}