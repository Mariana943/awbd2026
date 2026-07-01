package com.spital.hospitalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.spital.hospitalmanagement.model.*;
import com.spital.hospitalmanagement.repository.*;
import com.spital.hospitalmanagement.repository.TratamentRepository;

/**
 * Clasa principală a apliacției Hospital Management
 * Această clasă pornește aplicația Spring Boot și inițiază toate componentele necesare
 */
@SpringBootApplication
public class HospitalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }
    @Bean
    CommandLineRunner initData(
            PacientRepository pacientRepository,
            MedicRepository medicRepository,
            SectieRepository sectieRepository,
    FisaMedicalaRepository fisaMedicalaRepository,
            TratamentRepository tratamentRepository,
            ConsultatieRepository consultatieRepository,
            InternareRepository internareRepository,
            DiagnosticRepository diagnosticRepository){

        return args -> {

            Sectie sectie = new Sectie();
            sectie.setNumeSectie("Cardiologie");
            sectie.setEtaj(1);
            sectieRepository.save(sectie);

            Medic medic = new Medic();
            medic.setNume("Popescu");
            medic.setPrenume("Ion");
            medic.setSpecializare("Cardiolog");
            medic.setTelefon("0723456789");
            medic.setSectie(sectie);
            medicRepository.save(medic);

            Pacient pacient = new Pacient();
            pacient.setNume("Ionescu");
            pacient.setPrenume("Maria");
            pacient.setCnp("2890101123456");
            pacient.setTelefon("0712345678");
            pacient.setAdresa("Focsani");
            pacientRepository.save(pacient);

            FisaMedicala fisa = new FisaMedicala();
            fisa.setPacient(pacient);
            fisa.setGrupaSanguina("A+");
            fisa.setAlergii("Polen");
            fisa.setAntecedenteMedicale("Hipertensiune");

            fisaMedicalaRepository.save(fisa);
            Tratament tratament = new Tratament();
            tratament.setDenumire("Paracetamol");
            tratament.setDescriere("Administrare 1 comprimat la 8 ore");

            tratamentRepository.save(tratament);
            Consultatie consultatie = new Consultatie();
            consultatie.setPacient(pacient);
            consultatie.setMedic(medic);
            consultatie.setObservatii("Control de rutina");

            consultatieRepository.save(consultatie);

            Diagnostic diagnostic = new Diagnostic();
            diagnostic.setDenumire("Hipertensiune arteriala");
            diagnostic.setDescriere("Tensiune arteriala crescuta");

            diagnosticRepository.save(diagnostic);


            Internare internare = new Internare();
            internare.setPacient(pacient);
            internare.setSectie(sectie);

            internareRepository.save(internare);
        };
    }
}
