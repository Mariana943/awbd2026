package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Internare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternareRepository extends JpaRepository<Internare, Long> {
}