package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Medic;
import com.spital.hospitalmanagement.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;




/**
 * Service pentru gestionarea medicilor.
 * Conține logica de business pentru operațiile efectuate asupra medicilor.
 */
@Service
public class MedicService {

    // Repository utilizat pentru accesul la datele medicilor
    private final MedicRepository medicRepository;

    //Constructorul care inițializează repository-ul pentru medici
    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    // Returnează toți medicii din baza de date
    public List<Medic> getAllMedici() {
        return medicRepository.findAll();
    }

    // Salvează un medic nou
    public Medic saveMedic(Medic medic) {
        return medicRepository.save(medic);
    }

    // Caută un medic după ID
    public Medic getMedicById(Long id) {
        return medicRepository.findById(id).orElse(null);
    }

    // Șterge un medic după ID
    public void deleteMedic(Long id) {
        medicRepository.deleteById(id);
    }

    // Actualizează informațiile unui medic existent
    public Medic updateMedic(Long id, Medic medicNou) {

                    // Caută medicul dupa ID
            Medic medic = medicRepository.findById(id).orElse(null);

            //Daca medicul existaxse actualizeaza datele
        if (medic != null) {
            medic.setNume(medicNou.getNume());
            medic.setPrenume(medicNou.getPrenume());
            medic.setSpecializare(medicNou.getSpecializare());
            medic.setTelefon(medicNou.getTelefon());

            return medicRepository.save(medic);
        }

//Daca medicul nu exista ,returneaza null
        return null;
    }

    //Returneaza medicii împărțiți pe pagini
    public Page<Medic> getMediciPaginati(Pageable pageable) {
        return medicRepository.findAll(pageable);
    }
}