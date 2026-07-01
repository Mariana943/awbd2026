package com.spital.hospitalmanagement.repository;

import com.spital.hospitalmanagement.model.Tratament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repository pentru entitatea tratament
// Oferă operații de acces la baza de date pentru tratamente
@Repository
public interface TratamentRepository extends JpaRepository<Tratament, Long> {
}