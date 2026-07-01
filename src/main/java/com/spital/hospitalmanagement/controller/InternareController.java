package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Internare;
import com.spital.hospitalmanagement.service.InternareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller pentru gestionarea internărilor
 *Permite afișarea,adăugarea,cătarrea și ștergerea internărilor
 */
@RestController
@RequestMapping("/internari")
public class InternareController {

    //Serviciul care gestionează operațiile pentru internări
    private final InternareService internareService;

    //Constructor care primește și inițializează serviciul pentru internare.
    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din InernareService
    public InternareController(InternareService internareService) {
        this.internareService = internareService;
    }

//Afișează toate internările din baza de date
    @GetMapping
    public List<Internare> getAllInternari() {
        return internareService.getAllInternari();
    }

    //Afișează o internare nouă în baza de date
    @PostMapping
    public Internare addInternare(@RequestBody Internare internare) {
        return internareService.saveInternare(internare);
    }

    //Caută o internare după ID
    @GetMapping("/{id}")
    public Internare getInternareById(@PathVariable Long id) {
        return internareService.getInternareById(id);
    }

    //Șterge o internare din baza de date după ID
    @DeleteMapping("/{id}")
    public void deleteInternare(@PathVariable Long id) {
        internareService.deleteInternare(id);
    }
}