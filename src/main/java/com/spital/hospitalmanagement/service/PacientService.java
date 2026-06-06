package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Pacient;
import com.spital.hospitalmanagement.repository.PacientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PacientService {

    private final PacientRepository pacientRepository;

    public PacientService(PacientRepository pacientRepository) {
        this.pacientRepository = pacientRepository;
    }

    public List<Pacient> getAllPacienti() {
        return pacientRepository.findAll();
    }

    public Pacient savePacient(Pacient pacient) {
        return pacientRepository.save(pacient);
    }

    public Pacient getPacientById(Long id) {
        return pacientRepository.findById(id).orElse(null);
    }

    public void deletePacient(Long id) {
        pacientRepository.deleteById(id);
    }
    public Pacient updatePacient(Long id, Pacient pacientNou) {
        Pacient pacient = pacientRepository.findById(id).orElse(null);

        if (pacient != null) {
            pacient.setNume(pacientNou.getNume());
            pacient.setPrenume(pacientNou.getPrenume());
            pacient.setCnp(pacientNou.getCnp());
            pacient.setTelefon(pacientNou.getTelefon());
            pacient.setAdresa(pacientNou.getAdresa());

            return pacientRepository.save(pacient);
        }

        return null;
    }
    public Page<Pacient> getPacientiPaginati(Pageable pageable) {
        return pacientRepository.findAll(pageable);
    }

}