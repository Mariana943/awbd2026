package com.spital.hospitalmanagement.service;

import com.spital.hospitalmanagement.model.Diagnostic;
import com.spital.hospitalmanagement.repository.DiagnosticRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class DiagnosticService {

    private final DiagnosticRepository diagnosticRepository;

    public DiagnosticService(DiagnosticRepository diagnosticRepository) {
        this.diagnosticRepository = diagnosticRepository;
    }

    public List<Diagnostic> getAllDiagnostice() {
        return diagnosticRepository.findAll();
    }

    public Diagnostic saveDiagnostic(Diagnostic diagnostic) {
        return diagnosticRepository.save(diagnostic);
    }

    public Diagnostic getDiagnosticById(Long id) {
        return diagnosticRepository.findById(id).orElse(null);
    }

    public void deleteDiagnostic(Long id) {
        diagnosticRepository.deleteById(id);
    }
    public Diagnostic updateDiagnostic(Long id, Diagnostic diagnosticNou) {
        Diagnostic diagnostic = diagnosticRepository.findById(id).orElse(null);

        if (diagnostic != null) {
            diagnostic.setDenumire(diagnosticNou.getDenumire());
            diagnostic.setDescriere(diagnosticNou.getDescriere());
            return diagnosticRepository.save(diagnostic);
        }

        return null;
    }
    public Page<Diagnostic> getDiagnosticePaginati(Pageable pageable) {
        return diagnosticRepository.findAll(pageable);
    }
}