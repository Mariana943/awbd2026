package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Diagnostic;
import com.spital.hospitalmanagement.repository.DiagnosticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service pentru gestionarea diagnosticelor.
 * Conține logica de business pentru operațiile efectuate asupra diagnosticelor.
 */
@Service
public class DiagnosticService {

    // Repository utilizat pentru accesul la datele diagnosticelor
    private final DiagnosticRepository diagnosticRepository;

    //Constructorul care inițializează repository-ul pentru diagnostice
    public DiagnosticService(DiagnosticRepository diagnosticRepository) {
        this.diagnosticRepository = diagnosticRepository;
    }

    // Returnează toate diagnosticele din baza de date
    public List<Diagnostic> getAllDiagnostice() {
        return diagnosticRepository.findAll();
    }

    // Salvează un diagnostic nou
    public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
        return diagnosticRepository.save(diagnostic);
    }

    // Caută un diagnostic după ID
    public Diagnostic getDiagnosticById(Long id) {
        return diagnosticRepository.findById(id).orElse(null);
    }

    // Șterge un diagnostic după ID
    public void deleteDiagnostic(Long id) {
        diagnosticRepository.deleteById(id);
    }

    // Actualizează informațiile unui diagnostic existent
    public Diagnostic updateDiagnostic(Long id, Diagnostic diagnosticNou) {

        // Caută diagnosticul în baza de date
        Diagnostic diagnostic = diagnosticRepository.findById(id).orElse(null);

        // Dacă diagnosticul există, se actualizează datele
        if (diagnostic != null) {
            diagnostic.setDenumire(diagnosticNou.getDenumire());
            diagnostic.setDescriere(diagnosticNou.getDescriere());

            return diagnosticRepository.save(diagnostic);
        }

        // Dacă nu există, se returnează null
        return null;
    }

    // Returnează diagnosticele împărțite pe pagini
    public Page<Diagnostic> getDiagnosticePaginati(Pageable pageable) {
        return diagnosticRepository.findAll(pageable);
    }
}