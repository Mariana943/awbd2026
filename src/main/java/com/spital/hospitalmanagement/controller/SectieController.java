package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Sectie;
import com.spital.hospitalmanagement.service.SectieService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sectii")
public class SectieController {

    private final SectieService sectieService;

    public SectieController(SectieService sectieService) {
        this.sectieService = sectieService;
    }

    @GetMapping
    public List<Sectie> getAllSectii() {
        return sectieService.getAllSectii();
    }

    @PostMapping
    public Sectie addSectie(@Valid@RequestBody Sectie sectie) {
        return sectieService.saveSectie(sectie);
    }

    @GetMapping("/{id}")
    public Sectie getSectieById(@PathVariable Long id) {
        return sectieService.getSectieById(id);
    }

    @PutMapping("/{id}")
    public Sectie updateSectie(@PathVariable Long id,
                               @RequestBody Sectie sectie) {
        return sectieService.updateSectie(id, sectie);
    }
    @DeleteMapping("/{id}")
    public void deleteSectie(@PathVariable Long id) {
        sectieService.deleteSectie(id);
    }
}