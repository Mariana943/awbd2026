package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Consultatie;
import com.spital.hospitalmanagement.service.ConsultatieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller pentru gestionarea consultațiilor.
 * Permite afișarea ,adăugarea,căutarea și ștergerea consultațiilor.
 */
@RestController
@RequestMapping("/consultatii")
public class ConsultatieController {

    //Serviciul care gestionează operațiile pentru consultații
    private final ConsultatieService consultatieService;

    //  //Constructor care primește și inițializează serviciul pentru consultatie .
    //    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din ConsultatieService
    public ConsultatieController(ConsultatieService consultatieService) {
        this.consultatieService = consultatieService;
    }

    //Afișează toate consultațiile din baza de date
    @GetMapping
    public List<Consultatie> getAllConsultatii() {
        return consultatieService.getAllConsultatii();
    }

    //Adaugă o consultație nouă în baza de date
    @PostMapping
    public Consultatie addConsultatie(@RequestBody Consultatie consultatie) {
        return consultatieService.saveConsultatie(consultatie);
    }

    //Caută și afișează o consultație după ID
    @GetMapping("/{id}")
    public Consultatie getConsultatieById(@PathVariable Long id) {
        return consultatieService.getConsultatieById(id);
    }

    //Șterge o consultație din baza de date după ID
    @DeleteMapping("/{id}")
    public void deleteConsultatie(@PathVariable Long id) {
        consultatieService.deleteConsultatie(id);
    }
}