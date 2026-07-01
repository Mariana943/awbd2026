package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.FisaMedicala;
import com.spital.hospitalmanagement.repository.FisaMedicalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pentru gestionarea fișelor medicale.
 * Conține operațiile de afișare și actualizare a fișelor medicale.
 */
@Service
public class FisaMedicalaService {

    // Repository utilizat pentru accesul la datele fișelor medicale
    private final FisaMedicalaRepository fisaMedicalaRepository;

    //Constructorul care inițializează repository-ul pentru fișa medicală
    public FisaMedicalaService(FisaMedicalaRepository fisaMedicalaRepository) {
        this.fisaMedicalaRepository = fisaMedicalaRepository;
    }

    // Returnează toate fișele medicale din baza de date
    public List<FisaMedicala> getAllFiseMedicale() {
        return fisaMedicalaRepository.findAll();
    }

    // Actualizează informațiile unei fișe medicale existente
    public FisaMedicala updateFisaMedicala(Long id, FisaMedicala fisaNoua) {

        // Caută fișa medicală după ID
        FisaMedicala fisa = fisaMedicalaRepository.findById(id).orElse(null);

        // Dacă fișa există, se actualizează datele
        if (fisa != null) {
            fisa.setGrupaSanguina(fisaNoua.getGrupaSanguina());
            fisa.setAlergii(fisaNoua.getAlergii());
            fisa.setAntecedenteMedicale(fisaNoua.getAntecedenteMedicale());

            return fisaMedicalaRepository.save(fisa);
        }

        // Dacă fișa nu există, se returnează null
        return null;
    }
}