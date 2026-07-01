package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Pacient;
import com.spital.hospitalmanagement.service.PacientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

//Controller rest pentru gestionarea pacienților
//Permite afișarea ,adăugarea,actualizarea și ștergerea pacientiilor.
@RestController
@RequestMapping("/pacienti")
public class PacientController {

    //Serviciul care gestionează operațiile pentru pacienți
    private final PacientService pacientService;

    //Constructor care primește și inițializează serviciul pentru pacienți.
    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din PacientService
    public PacientController(PacientService pacientService) {
        this.pacientService = pacientService;
    }

    //Afisam lista tuturor pacienților
    @GetMapping
    public List<Pacient> getAllPacienti() {
        return pacientService.getAllPacienti();
    }

    //Afișează pacienții folosind paginarea
    @GetMapping("/pagina")
    public Page<Pacient> getPacientiPaginati(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return pacientService.getPacientiPaginati(pageable);
    }
//Operatiile CRUD (Create,Read,Update,Delete)
    //Adauga un pacient nou în baza de date
    @PostMapping
    public Pacient addPacient(@Valid@RequestBody Pacient pacient) {
        return pacientService.savePacient(pacient);
    }

    //Caută și afișează un pacient după ID
    @GetMapping("/{id}")
    public Pacient getPacientById(@PathVariable Long id) {
        return pacientService.getPacientById(id);
    }

    //Șterge un pacient din baza de date după ID
    @DeleteMapping("/{id}")
    public void deletePacient(@PathVariable Long id) {
        pacientService.deletePacient(id);
    }

    //Actualizează datele unui pacient existent
    @PutMapping("/{id}")
    public Pacient updatePacient(@PathVariable Long id,
                                 @RequestBody Pacient pacient) {
        return pacientService.updatePacient(id, pacient);
    }
}