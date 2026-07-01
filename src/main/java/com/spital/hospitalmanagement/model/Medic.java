package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;

/**Entitatea Medic
 *Reprezintă informațiile despre medicii din spital.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Medic {
    //Identificator unic al medicului
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Numele medicului
@NotBlank
    private String nume;

//Prenumele medicului
    @NotBlank
    private String prenume;

    //Specializarea medicului
    @NotBlank
    private String specializare;

    //Numărul de telefon al medicului
    @NotBlank
    private String telefon;

    //Secția în care lucrează medicul
    @ManyToOne
    @JoinColumn(name = "sectie_id")
    private Sectie sectie;
}