package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Tratament;
import com.spital.hospitalmanagement.repository.TratamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clasa de serviciu care gestioneaza operațiile pentru entitatea Tratament.
 */
@Service
public class TratamentService {

    //Repository utilizat pentru accesul la datele tratamentelor
    private final TratamentRepository tratamentRepository;

    //Constructorul care inițializează repository-ul pentru tratamente
    public TratamentService(TratamentRepository tratamentRepository) {
        this.tratamentRepository = tratamentRepository;
    }

    //Returneaza lista tuturor tratamentelor existente
    public List<Tratament> getAllTratamente() {
        return tratamentRepository.findAll();
    }

    //Salvează un tratament nou în baza de date
    public Tratament saveTratament(Tratament tratament) {
        return tratamentRepository.save(tratament);
    }

    //Caută și returnează un tratament dupa ID
    public Tratament getTratamentById(Long id) {
        return tratamentRepository.findById(id).orElse(null);
    }

    //Șterge un tratament pe baza ID-ului
    public void deleteTratament(Long id) {
        tratamentRepository.deleteById(id);
    }

    //Actualizează informațiile unui tratament existent
    public Tratament updateTratament(Long id, Tratament tratamentNou) {
        Tratament tratament = tratamentRepository.findById(id).orElse(null);

        //Verifică dacă tratamentul există în baza de date
        if (tratament != null) {
            tratament.setDenumire(tratamentNou.getDenumire()); //Actualizează denumirea tratamentului
            tratament.setDescriere(tratamentNou.getDescriere()); //Actualizează descrierea tratamentului

            return tratamentRepository.save(tratament);//Salvează modificările efectuate
        }

        return null; //Returnerază null,daca tratamentul nu a fost gasit
    }
}