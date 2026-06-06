package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Tratament;
import com.spital.hospitalmanagement.repository.TratamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TratamentService {

    private final TratamentRepository tratamentRepository;

    public TratamentService(TratamentRepository tratamentRepository) {
        this.tratamentRepository = tratamentRepository;
    }

    public List<Tratament> getAllTratamente() {
        return tratamentRepository.findAll();
    }

    public Tratament saveTratament(Tratament tratament) {
        return tratamentRepository.save(tratament);
    }

    public Tratament getTratamentById(Long id) {
        return tratamentRepository.findById(id).orElse(null);
    }

    public void deleteTratament(Long id) {
        tratamentRepository.deleteById(id);
    }
    public Tratament updateTratament(Long id, Tratament tratamentNou) {
        Tratament tratament = tratamentRepository.findById(id).orElse(null);

        if (tratament != null) {
            tratament.setDenumire(tratamentNou.getDenumire());
            tratament.setDescriere(tratamentNou.getDescriere());

            return tratamentRepository.save(tratament);
        }

        return null;
    }
}