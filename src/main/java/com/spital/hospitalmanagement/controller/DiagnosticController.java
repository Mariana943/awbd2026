package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Diagnostic;
import com.spital.hospitalmanagement.service.DiagnosticService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * Controller pentru gestionarea diagnosticelor.
 * Permite afișarea,adăugarea,actualizarea și stergerea diagnosticelor.
 */
@RestController
@RequestMapping("/diagnostice")
public class DiagnosticController {

    //Serviciu care gestionează operațiile pentru diagnostice
    private final DiagnosticService diagnosticService;

    //Constructor care primește și inițializează serviciul pentru diagnostice.
    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din DiagnosticService
    public DiagnosticController(DiagnosticService diagnosticService) {
        this.diagnosticService = diagnosticService;
    }

    //Afișează toate diagnosticele din baza de date
    @GetMapping
    public List<Diagnostic> getAllDiagnostice() {
        return diagnosticService.getAllDiagnostice();
    }

    //Afișează diagnosticele folosing paginarea
    @GetMapping("/pagina")
    public Page<Diagnostic> getDiagnosticePaginati(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return diagnosticService.getDiagnosticePaginati(pageable);
    }

    //Adaugă un diagnostic nou în baza de date
    @PostMapping
    public Diagnostic addDiagnostic(@Valid@RequestBody Diagnostic diagnostic) {
        return diagnosticService.saveDiagnostic(diagnostic);
    }

    //Caută un diagnostic după ID
    @GetMapping("/{id}")
    public Diagnostic getDiagnosticById(@PathVariable Long id) {
        return diagnosticService.getDiagnosticById(id);
    }

    //Actualizează datele unui diagnostic existent
    @PutMapping("/{id}")
    public Diagnostic updateDiagnostic(@PathVariable Long id,
                                       @RequestBody Diagnostic diagnostic) {
        return diagnosticService.updateDiagnostic(id, diagnostic);
    }

    //Șterge un diagnostic din baza de date după ID
    @DeleteMapping("/{id}")
    public void deleteDiagnostic(@PathVariable Long id) {
        diagnosticService.deleteDiagnostic(id);
    }
}