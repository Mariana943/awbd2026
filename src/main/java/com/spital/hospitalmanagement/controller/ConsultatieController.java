package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Consultatie;
import com.spital.hospitalmanagement.service.ConsultatieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultatii")
public class ConsultatieController {

    private final ConsultatieService consultatieService;

    public ConsultatieController(ConsultatieService consultatieService) {
        this.consultatieService = consultatieService;
    }

    @GetMapping
    public List<Consultatie> getAllConsultatii() {
        return consultatieService.getAllConsultatii();
    }

    @PostMapping
    public Consultatie addConsultatie(@RequestBody Consultatie consultatie) {
        return consultatieService.saveConsultatie(consultatie);
    }

    @GetMapping("/{id}")
    public Consultatie getConsultatieById(@PathVariable Long id) {
        return consultatieService.getConsultatieById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteConsultatie(@PathVariable Long id) {
        consultatieService.deleteConsultatie(id);
    }
}