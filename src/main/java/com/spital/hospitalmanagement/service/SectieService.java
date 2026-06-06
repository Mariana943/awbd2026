package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Sectie;
import com.spital.hospitalmanagement.repository.SectieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectieService {

    private final SectieRepository sectieRepository;

    public SectieService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    public List<Sectie> getAllSectii() {
        return sectieRepository.findAll();
    }

    public Sectie saveSectie(Sectie sectie) {
        return sectieRepository.save(sectie);
    }

    public Sectie getSectieById(Long id) {
        return sectieRepository.findById(id).orElse(null);
    }

    public void deleteSectie(Long id) {
        sectieRepository.deleteById(id);
    }
    public Sectie updateSectie(Long id, Sectie sectieNoua) {
        Sectie sectie = sectieRepository.findById(id).orElse(null);

        if (sectie != null) {
            sectie.setNumeSectie(sectieNoua.getNumeSectie());
            sectie.setEtaj(sectieNoua.getEtaj());

            return sectieRepository.save(sectie);
        }

        return null;
    }
}