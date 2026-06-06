package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Pacient;
import com.spital.hospitalmanagement.service.PacientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/pacienti")
public class PacientController {

    private final PacientService pacientService;

    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    @GetMapping
    public List<Pacient> getAllPacienti() {
        return pacientService.getAllPacienti();
    }

    @GetMapping("/pagina")
    public Page<Pacient> getPacientiPaginati(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return pacientService.getPacientiPaginati(pageable);
    }

    @PostMapping
    public Pacient addPacient(@Valid@RequestBody Pacient pacient) {
        return pacientService.savePacient(pacient);
    }

    @GetMapping("/{id}")
    public Pacient getPacientById(@PathVariable Long id) {
        return pacientService.getPacientById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePacient(@PathVariable Long id) {
        pacientService.deletePacient(id);
    }
    @PutMapping("/{id}")
    public Pacient updatePacient(@PathVariable Long id,
                                 @RequestBody Pacient pacient) {
        return pacientService.updatePacient(id, pacient);
    }
}