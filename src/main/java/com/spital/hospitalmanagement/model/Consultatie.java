package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.time.LocalDate;

 /**Entitatea Consultație
 *Reprezintă consultația medicală efectuată de un medic pentru un pacient
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consultatie {

    //Identificator unic al consultației
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Data la care a avut loc consultația
    private LocalDate dataConsultatie;

    //Observațiile medicului
    private String observatii;

    //Pacientul care participă la consultație
    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

    //Medicul care efectuează consultația
    @ManyToOne
    @JoinColumn(name = "medic_id")
    private Medic medic;

    //Diagnosticul stabilit în urma consultației
    private String diagnostic;

    //Lista tratamentelor recomandate în cadrul consultației
    @ManyToMany
    @JoinTable(
            name = "consultatie_tratament",
            joinColumns = @JoinColumn(name = "consultatie_id"),
            inverseJoinColumns = @JoinColumn(name = "tratament_id")
    )
    private List<Tratament> tratamente;

     //Lista diagnosticelor asociate consultației
    @ManyToMany
    @JoinTable(
            name = "consultatie_diagnostic",
            joinColumns = @JoinColumn(name = "consultatie_id"),
            inverseJoinColumns = @JoinColumn(name = "diagnostic_id")
    )
    private List<Diagnostic> diagnostice;
}