package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Internare;
import com.spital.hospitalmanagement.repository.InternareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pentru gestionarea internărilor.
 * Conține operațiile de afișare, adăugare, căutare și ștergere a internărilor.
 */
@Service
public class InternareService {

    // Repository utilizat pentru accesul la datele internărilor
    private final InternareRepository internareRepository;

    //Constructorul care inițializează repository-ul pentru internare
    public InternareService(InternareRepository internareRepository) {
        this.internareRepository = internareRepository;
    }

    // Returnează toate internările din baza de date
    public List<Internare> getAllInternari() {
        return internareRepository.findAll();
    }

    // Salvează o internare nouă
    public Internare saveInternare(Internare internare) {
        return internareRepository.save(internare);
    }

    // Caută o internare după ID
    public Internare getInternareById(Long id) {
        return internareRepository.findById(id).orElse(null);
    }

    // Șterge o internare după ID
    public void deleteInternare(Long id) {
        internareRepository.deleteById(id);
    }
}