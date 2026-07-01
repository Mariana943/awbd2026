package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Sectie;
import com.spital.hospitalmanagement.service.SectieService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller rest pentru gestionarea sec'iilor din spital.
//Permite afișarea ,adăugarea,actualizarea și ștergerea secțiilor
@RestController
@RequestMapping("/sectii")
public class SectieController {

    //Serviciul care gestionează operațiile pentru secții
    private final SectieService sectieService;

    //Constructor care primește și inițializează serviciul pentru secții.
    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din SecțieService
    public SectieController(SectieService sectieService) {
        this.sectieService = sectieService;
    }

    //Afisează toate secțiile din spital
    @GetMapping
    public List<Sectie> getAllSectii() {
        return sectieService.getAllSectii();
    }


    //Adauga o secție  nouă în baza de date
    @PostMapping
    public Sectie addSectie(@Valid@RequestBody Sectie sectie) {
        return sectieService.saveSectie(sectie);
    }
    //Caută o secție după ID
    @GetMapping("/{id}")
    public Sectie getSectieById(@PathVariable Long id) {
        return sectieService.getSectieById(id);
    }

    //Actualizează datele unei secții existente
    @PutMapping("/{id}")
    public Sectie updateSectie(@PathVariable Long id,
                               @RequestBody Sectie sectie) {
        return sectieService.updateSectie(id, sectie);
    }

    //Șterge o secție după ID
    @DeleteMapping("/{id}")
    public void deleteSectie(@PathVariable Long id) {
        sectieService.deleteSectie(id);
    }
}