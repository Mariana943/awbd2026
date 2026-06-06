package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Diagnostic;
import com.spital.hospitalmanagement.service.DiagnosticService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/diagnostice")
public class DiagnosticController {

    private final DiagnosticService diagnosticService;

    public DiagnosticController(DiagnosticService diagnosticService) {
        this.diagnosticService = diagnosticService;
    }

    @GetMapping
    public List<Diagnostic> getAllDiagnostice() {
        return diagnosticService.getAllDiagnostice();
    }
    @GetMapping("/pagina")
    public Page<Diagnostic> getDiagnosticePaginati(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return diagnosticService.getDiagnosticePaginati(pageable);
    }
    @PostMapping
    public Diagnostic addDiagnostic(@Valid@RequestBody Diagnostic diagnostic) {
        return diagnosticService.saveDiagnostic(diagnostic);
    }

    @GetMapping("/{id}")
    public Diagnostic getDiagnosticById(@PathVariable Long id) {
        return diagnosticService.getDiagnosticById(id);
    }

    @PutMapping("/{id}")
    public Diagnostic updateDiagnostic(@PathVariable Long id,
                                       @RequestBody Diagnostic diagnostic) {
        return diagnosticService.updateDiagnostic(id, diagnostic);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnostic(@PathVariable Long id) {
        diagnosticService.deleteDiagnostic(id);
    }
}