package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Tratament;
import com.spital.hospitalmanagement.service.TratamentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tratamente")
public class TratamentController {

    private final TratamentService tratamentService;

    public TratamentController(TratamentService tratamentService) {
        this.tratamentService = tratamentService;
    }

    @GetMapping
    public List<Tratament> getAllTratamente() {
        return tratamentService.getAllTratamente();
    }

    @PostMapping
    public Tratament addTratament(@Valid@RequestBody Tratament tratament) {
        return tratamentService.saveTratament(tratament);
    }

    @GetMapping("/{id}")
    public Tratament getTratamentById(@PathVariable Long id) {
        return tratamentService.getTratamentById(id);
    }

    @PutMapping("/{id}")
    public Tratament updateTratament(@PathVariable Long id,
                                     @RequestBody Tratament tratament) {
        return tratamentService.updateTratament(id, tratament);
    }

    @DeleteMapping("/{id}")
    public void deleteTratament(@PathVariable Long id) {
        tratamentService.deleteTratament(id);
    }
}