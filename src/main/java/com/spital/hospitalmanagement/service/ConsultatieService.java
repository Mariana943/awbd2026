package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Consultatie;
import com.spital.hospitalmanagement.repository.ConsultatieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultatieService {

    private final ConsultatieRepository consultatieRepository;

    public ConsultatieService(ConsultatieRepository consultatieRepository) {
        this.consultatieRepository = consultatieRepository;
    }

    public List<Consultatie> getAllConsultatii() {
        return consultatieRepository.findAll();
    }

    public Consultatie saveConsultatie(Consultatie consultatie) {
        return consultatieRepository.save(consultatie);
    }

    public Consultatie getConsultatieById(Long id) {
        return consultatieRepository.findById(id).orElse(null);
    }

    public void deleteConsultatie(Long id) {
        consultatieRepository.deleteById(id);
    }
}