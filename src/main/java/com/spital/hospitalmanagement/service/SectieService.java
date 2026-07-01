package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Sectie;
import com.spital.hospitalmanagement.repository.SectieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clasa de serviciu care gestioneaza operațiile pentru entitatea Secție.
 */
@Service
public class SectieService {

    //Repository utilizat pentru accesul la baza de date
    private final SectieRepository sectieRepository;

    //Constructorul care inițializează repository-ul pentru secții
    public SectieService(SectieRepository sectieRepository) {
        this.sectieRepository = sectieRepository;
    }

    //Returneaza lista tuturor secțiilor din spital
    public List<Sectie> getAllSectii() {
        return sectieRepository.findAll();
    }

    //Salvează o secție nouă în baza de date
    public Sectie saveSectie(Sectie sectie) {
        return sectieRepository.save(sectie);
    }

    //Caută și returnează o secție după ID
    public Sectie getSectieById(Long id) {
        return sectieRepository.findById(id).orElse(null);
    }

//Șterge o secție pe baza de ID-ului
    public void deleteSectie(Long id) {
        sectieRepository.deleteById(id);
    }

    //Actualizează informațiile unei secții existente
    public Sectie updateSectie(Long id, Sectie sectieNoua) {
        Sectie sectie = sectieRepository.findById(id).orElse(null);

        //Verifică dacă secția există în baza de date
        if (sectie != null) {
            sectie.setNumeSectie(sectieNoua.getNumeSectie()); //Actualizează numele secției
            sectie.setEtaj(sectieNoua.getEtaj());//Actualizează etajul secției

            return sectieRepository.save(sectie);//Salvează modificăriler în baza de date
        }

        return null; //Returnează null,daca sectia nu exista
    }
}