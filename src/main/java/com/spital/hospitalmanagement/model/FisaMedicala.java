package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

/**Entitatea Fișă medicală
 *Reprezintă fișa medicală asociată unui pacient
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FisaMedicala {

 //Identificator unic al fișei medicale
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Grupa sanguină a pacientului
    private String grupaSanguina;

    //Alergiile cunoscute ale pacientului
    private String alergii;

    //Antecedentele medicale ale pacientului
    private String antecedenteMedicale;

    //Relația unu la unu cu pacientul.
    //O fișă medicală aparține unui singur pacient,iar un pacient are o singură fișă medicală
    @OneToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;
}