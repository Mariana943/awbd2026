package com.spital.hospitalmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Entitatea pacient reprezinta informatiile unui pacient din sistemul de managemnt al spitalului.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         //Identificatorul unui al pacientului.
    private Long id;

    @NotBlank(message = "Numele este obligatoriu")
    @Size(min = 2, max = 50)
    private String nume;                     //Numele pacientului

    @NotBlank(message = "Prenumele este obligatoriu")
    @Size(min = 2, max = 50)
    private String prenume;         //Prenumele pacientului

    @Column(unique = true, nullable = false)
    @NotBlank(message = "CNP-ul este obligatoriu")
    @Size(min = 13, max = 13)
    private String cnp;             //Cod numeric personal

    @NotBlank(message = "Telefonul este obligatoriu")
    private String telefon;    //Numarul de telefon al pacientului

    private String adresa;      // Adresa pacientului
    @JsonIgnore
    @OneToOne(mappedBy = "pacient", cascade= CascadeType.ALL)   // Defineste relatia OneToOne dintre pacient si fisa medicala
    private FisaMedicala fisaMedicala;

}