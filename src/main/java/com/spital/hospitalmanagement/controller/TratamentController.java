package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Tratament;
import com.spital.hospitalmanagement.service.TratamentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller pentru gestionarea tratamentelor.
 * Permite afișarea,adăugarea,actualizarea și stergerea tratamentelor.
 */
@RestController
@RequestMapping("/tratamente")
public class TratamentController {

    //Serviciu care gestionează operațiile pentru tratamente
    private final TratamentService tratamentService;

    //Constructor care primește și inițializează serviciul pentru tratamente.
    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din TratamentService
    public TratamentController(TratamentService tratamentService) {
        this.tratamentService = tratamentService;
    }

    //Afișează toate tratamentele
    @GetMapping
    public List<Tratament> getAllTratamente() {
        return tratamentService.getAllTratamente();
    }

    //Adaugă un tratament nou în baza de date
    @PostMapping
    public Tratament addTratament(@Valid@RequestBody Tratament tratament) {
        return tratamentService.saveTratament(tratament);
    }

    //Caută un tratament după ID
    @GetMapping("/{id}")
    public Tratament getTratamentById(@PathVariable Long id) {
        return tratamentService.getTratamentById(id);
    }

    //Actualizează datele unui tratament existent
    @PutMapping("/{id}")
    public Tratament updateTratament(@PathVariable Long id,
                                     @RequestBody Tratament tratament) {
        return tratamentService.updateTratament(id, tratament);
    }


    //Șterge un tratament după ID
    @DeleteMapping("/{id}")
    public void deleteTratament(@PathVariable Long id) {
        tratamentService.deleteTratament(id);
    }
}