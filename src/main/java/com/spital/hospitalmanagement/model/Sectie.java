package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

/**Entitatea Secție
 *Reprezintă secțiile existente în cadrul  spitalului.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sectie {

    //Identificator unic al secției
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//Denumirea secției
    private String numeSectie;

    //Etajul  pe care află secția
    private Integer etaj;
}