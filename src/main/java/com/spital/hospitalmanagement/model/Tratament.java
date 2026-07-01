package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

/**Entitatea Tratament
 *Reprezintă tratamentul prescris pacientilor
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tratament {


    //Identificator unic al tratamentului
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//Denumirea tratamentului
    private String denumire;

    //Descrierea tratamentului
    private String descriere;
}