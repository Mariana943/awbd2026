package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@NotBlank
    private String nume;

    @NotBlank
    private String prenume;

    @NotBlank
    private String specializare;

    @NotBlank
    private String telefon;

    @ManyToOne
    @JoinColumn(name = "sectie_id")
    private Sectie sectie;
}