package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

/**Entitatea Diagnostic
 *Reprezintă un diagnostic medical asociat unui pacient
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Diagnostic {

    // //Identificator unic al diagnosticului
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//Denumire diagnostic
    private String denumire;

//Descrierea diagnosticului
    private String descriere;
}