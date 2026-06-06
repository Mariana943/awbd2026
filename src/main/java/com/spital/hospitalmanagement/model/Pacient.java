package com.spital.hospitalmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pacient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Numele este obligatoriu")
    @Size(min = 2, max = 50)
    private String nume;

    @NotBlank(message = "Prenumele este obligatoriu")
    @Size(min = 2, max = 50)
    private String prenume;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "CNP-ul este obligatoriu")
    @Size(min = 13, max = 13)
    private String cnp;

    @NotBlank(message = "Telefonul este obligatoriu")
    private String telefon;

    private String adresa;
    @JsonIgnore
    @OneToOne(mappedBy = "pacient", cascade= CascadeType.ALL)
    private FisaMedicala fisaMedicala;

}