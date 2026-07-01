package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**Entitatea Internare
 *Reprezintă internarea unui pacient într-o sectie a spitalului
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Internare {

    //Identificator unic al internării
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Data la care pacientul este internat
    private LocalDate dataInternare;

    //Data externării pacientului
    private LocalDate dataExternare;


    //Pacientul este internat
    @ManyToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;

//Secția în care este internat pacientul
    @ManyToOne
    @JoinColumn(name = "sectie_id")
    private Sectie sectie;
}