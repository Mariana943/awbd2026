package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Tratament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentRepository extends JpaRepository<Tratament, Long> {
}