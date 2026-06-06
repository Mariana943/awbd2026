package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.FisaMedicala;
import com.spital.hospitalmanagement.repository.FisaMedicalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FisaMedicalaService {

    private final FisaMedicalaRepository fisaMedicalaRepository;

    public FisaMedicalaService(FisaMedicalaRepository fisaMedicalaRepository) {
        this.fisaMedicalaRepository = fisaMedicalaRepository;
    }

    public List<FisaMedicala> getAllFiseMedicale() {
        return fisaMedicalaRepository.findAll();
    }
    public FisaMedicala updateFisaMedicala(Long id, FisaMedicala fisaNoua) {
        FisaMedicala fisa = fisaMedicalaRepository.findById(id).orElse(null);

        if (fisa != null) {
            fisa.setGrupaSanguina(fisaNoua.getGrupaSanguina());
            fisa.setAlergii(fisaNoua.getAlergii());
            fisa.setAntecedenteMedicale(fisaNoua.getAntecedenteMedicale());

            return fisaMedicalaRepository.save(fisa);
        }

        return null;
    }
}