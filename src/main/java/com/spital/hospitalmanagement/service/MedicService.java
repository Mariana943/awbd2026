package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Medic;
import com.spital.hospitalmanagement.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class MedicService {

    private final MedicRepository medicRepository;

    public MedicService(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    public List<Medic> getAllMedici() {
        return medicRepository.findAll();
    }

    public Medic saveMedic(Medic medic) {
        return medicRepository.save(medic);
    }

    public Medic getMedicById(Long id) {
        return medicRepository.findById(id).orElse(null);
    }

    public void deleteMedic(Long id) {
        medicRepository.deleteById(id);
    }
    public Medic updateMedic(Long id, Medic medicNou) {
        Medic medic = medicRepository.findById(id).orElse(null);

        if (medic != null) {
            medic.setNume(medicNou.getNume());
            medic.setPrenume(medicNou.getPrenume());
            medic.setSpecializare(medicNou.getSpecializare());
            medic.setTelefon(medicNou.getTelefon());

            return medicRepository.save(medic);
        }

        return null;
    }
    public Page<Medic> getMediciPaginati(Pageable pageable) {
        return medicRepository.findAll(pageable);
    }
}