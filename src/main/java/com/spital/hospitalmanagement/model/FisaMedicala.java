package com.spital.hospitalmanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FisaMedicala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String grupaSanguina;
    private String alergii;
    private String antecedenteMedicale;

    @OneToOne
    @JoinColumn(name = "pacient_id")
    private Pacient pacient;
}