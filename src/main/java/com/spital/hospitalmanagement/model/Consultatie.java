package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consultatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataConsultatie;

    private String observatii;

    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medic;

    private String diagnostic;

    @ManyToMany
    @JoinTable(
            name = "consultatie_tratament",
            joinColumns = @JoinColumn(name = "consultatie_id"),
            inverseJoinColumns = @JoinColumn(name = "tratament_id")
    )
    private List<Tratament> tratamente;
    @ManyToMany
    @JoinTable(
            name = "consultatie_diagnostic",
            joinColumns = @JoinColumn(name = "consultatie_id"),
            inverseJoinColumns = @JoinColumn(name = "diagnostic_id")
    )
    private List<Diagnostic> diagnostice;
}