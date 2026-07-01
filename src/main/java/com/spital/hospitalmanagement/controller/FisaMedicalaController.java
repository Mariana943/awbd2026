package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.FisaMedicala;
import com.spital.hospitalmanagement.service.FisaMedicalaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller pentru gestionarea fișelor medicale.
 * Permite afișarea și actualizarea fișelor medicale.
 */
@RestController
@RequestMapping("/fisemedicale")
public class FisaMedicalaController {

    //Serviciul care gestionează operațiile pentru fișele medicale
    private final FisaMedicalaService fisaMedicalaService;

    //Constructor care primește și inițializează serviciul pentru fișele medicale.
    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din FisaMedicalaService
    public FisaMedicalaController(FisaMedicalaService fisaMedicalaService) {
        this.fisaMedicalaService = fisaMedicalaService;
    }

    //Afisează toate fișele medicale din baza de date
    @GetMapping
    public List<FisaMedicala> getAllFiseMedicale() {
        return fisaMedicalaService.getAllFiseMedicale();
    }

    //Actualizează datele unei fișe medicale existente
    @PutMapping("/{id}")
    public FisaMedicala updateFisaMedicala(@PathVariable Long id,
                                           @RequestBody FisaMedicala fisa) {
        return fisaMedicalaService.updateFisaMedicala(id, fisa);
    }
}