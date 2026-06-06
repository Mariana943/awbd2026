package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Internare;
import com.spital.hospitalmanagement.repository.InternareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternareService {

    private final InternareRepository internareRepository;

    public InternareService(InternareRepository internareRepository) {
        this.internareRepository = internareRepository;
    }

    public List<Internare> getAllInternari() {
        return internareRepository.findAll();
    }

    public Internare saveInternare(Internare internare) {
        return internareRepository.save(internare);
    }

    public Internare getInternareById(Long id) {
        return internareRepository.findById(id).orElse(null);
    }
    public void deleteInternare(Long id) {
        internareRepository.deleteById(id);
    }
}