package com.spital.hospitalmanagement.controller;

import com.spital.hospitalmanagement.model.Internare;
import com.spital.hospitalmanagement.service.InternareService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/internari")
public class InternareController {

    private final InternareService internareService;

    public InternareController(InternareService internareService) {
        this.internareService = internareService;
    }

    @GetMapping
    public List<Internare> getAllInternari() {
        return internareService.getAllInternari();
    }

    @PostMapping
    public Internare addInternare(@RequestBody Internare internare) {
        return internareService.saveInternare(internare);
    }

    @GetMapping("/{id}")
    public Internare getInternareById(@PathVariable Long id) {
        return internareService.getInternareById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteInternare(@PathVariable Long id) {
        internareService.deleteInternare(id);
    }
}