package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Pacient;
import com.spital.hospitalmanagement.repository.PacientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Clasă Service care conține logica de business pentru gestionarea pacienților
 */
@Service
public class PacientService {

    private final PacientRepository pacientRepository; //Crează legătura cu baza de date prin Repository

//Constructorul care inițializează repository-ul pentru pacienți
    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    //Afișează toți pacienți din baza de date
    public List<Pacient> getAllPacienti() {
        return pacientRepository.findAll();
    }

    // Salvează un pacient nou în baza de date
    public Pacient savePacient(Pacient pacient) {
        return pacientRepository.save(pacient);
    }

    //Caută și returnează un pacient după ID
    public Pacient getPacientById(Long id) {
        return pacientRepository.findById(id).orElse(null);
    }

    //Șterge un pacient din baza de date
    public void deletePacient(Long id) {
        pacientRepository.deleteById(id);
    }

    //Actualizează datele unui pacient existent
    public Pacient updatePacient(Long id, Pacient pacientNou) {
        Pacient pacient = pacientRepository.findById(id).orElse(null);//Caută paceintul care trebuie modificat

        if (pacient != null) { //verifica dacă pacientul există în baza de date
            //Actualizează datele pacientului cu valori noi
            pacient.setNume(pacientNou.getNume());
            pacient.setPrenume(pacientNou.getPrenume());
            pacient.setCnp(pacientNou.getCnp());
            pacient.setTelefon(pacientNou.getTelefon());
            pacient.setAdresa(pacientNou.getAdresa());

            return pacientRepository.save(pacient);//Salvează modificările făcute în baza de date
        }

        return null; //Returnează null daca pacientul nu există
    }

    //Afișează pacienții pe pagini
    public Page<Pacient> getPacientiPaginati(Pageable pageable) {
        return pacientRepository.findAll(pageable);
    }

}