package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Medic;
import com.spital.hospitalmanagement.service.MedicService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

//Controller rest pentru gestionarea medicilor
//Permite afișarea ,adăugarea,actualizarea și ștergerea medicilor
@RestController
@RequestMapping("/medici")
public class MedicController {

    //Serviciul care gestionează operațiile pentru medici.
    private final MedicService medicService;

    //Constructor care primește și inițializează serviciul pentru medici.
    //Constructorul face legatura dintre controller și service. Prin intermediul lui pot apela metodele din MedicService
    public MedicController(MedicService medicService) {
        this.medicService = medicService;
    }

    //Rulează lista tuturor medicilor
    @GetMapping
    public List<Medic> getAllMedici() {
        return medicService.getAllMedici();
    }

    //Afișează medicii folosind paginarea
    @GetMapping("/pagina")
    public Page<Medic> getMediciPaginati(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return medicService.getMediciPaginati(pageable);
    }

    //Adauga un medic nou în baza de date
    @PostMapping
    public Medic addMedic(@Valid@RequestBody Medic medic) {
        return medicService.saveMedic(medic);
    }

    //Caută un medic după ID
    @GetMapping("/{id}")
    public Medic getMedicById(@PathVariable Long id) {
        return medicService.getMedicById(id);
    }

    //Șterge un medic după ID
    @DeleteMapping("/{id}")
    public void deleteMedic(@PathVariable Long id) {
        medicService.deleteMedic(id);
    }

    //Actualizează datele unui medic existent
    @PutMapping("/{id}")
    public Medic updateMedic(@PathVariable Long id,
                             @RequestBody Medic medic) {
        return medicService.updateMedic(id, medic);
    }

}