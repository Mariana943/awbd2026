package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Consultatie;
import com.spital.hospitalmanagement.repository.ConsultatieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pentru gestionarea consultațiilor
 * Conține logica de business pentru operațiile efectuate asupra consultațiilor
 */
@Service
public class ConsultatieService {

    //Repository utilizat pentru accesul la datele consultațiilor
    private final ConsultatieRepository consultatieRepository;


    //Constructorul care inițializează repository-ul pentru consultatii
    public ConsultatieService(ConsultatieRepository consultatieRepository) {
        this.consultatieRepository = consultatieRepository;
    }

    //Returnează toate consultațiile din baza de date
    public List<Consultatie> getAllConsultatii() {
        return consultatieRepository.findAll();
    }

//Salvează o consultație nouă
    public Consultatie saveConsultatie(Consultatie consultatie) {
        return consultatieRepository.save(consultatie);
    }

    //Caută o consultație după ID
    public Consultatie getConsultatieById(Long id) {
        return consultatieRepository.findById(id).orElse(null);
    }

    //Șterge o consultație după ID
    public void deleteConsultatie(Long id) {
        consultatieRepository.deleteById(id);
    }
}