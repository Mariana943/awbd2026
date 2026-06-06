package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.FisaMedicala;
import com.spital.hospitalmanagement.service.FisaMedicalaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fisemedicale")
public class FisaMedicalaController {

    private final FisaMedicalaService fisaMedicalaService;

    public FisaMedicalaController(FisaMedicalaService fisaMedicalaService) {
        this.fisaMedicalaService = fisaMedicalaService;
    }

    @GetMapping
    public List<FisaMedicala> getAllFiseMedicale() {
        return fisaMedicalaService.getAllFiseMedicale();
    }
    @PutMapping("/{id}")
    public FisaMedicala updateFisaMedicala(@PathVariable Long id,
                                           @RequestBody FisaMedicala fisa) {
        return fisaMedicalaService.updateFisaMedicala(id, fisa);
    }
}