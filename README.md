# Hospital Management

## Descriere proiect

Hospital Management este o aplicație web dezvoltată folosind Spring Boot pentru gestionarea activităților unui spital. Aplicația permite administrarea pacienților, medicilor, secțiilor, consultațiilor, internărilor, diagnosticelor și tratamentelor.

Scopul proiectului este digitalizarea proceselor medicale și organizarea eficientă a informațiilor din cadrul unui spital.

---


## Cerințe funcționale

- Adăugare pacient
- Modificare pacient
- Ștergere pacient
- Vizualizare pacienți

- Adăugare medic
- Modificare medic
- Ștergere medic
- Vizualizare medici

- Gestionare secții

- Gestionare internări

- Gestionare consultații

- Gestionare diagnostice

- Gestionare tratamente

- Validare date introduse

- Paginare rezultate

- Sortare rezultate

- Logging aplicație

- Testare servicii

- Configurare medii multiple (dev și test)

---
## Tehnologii utilizate

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database
- Maven
- JUnit
- Logback
- Git
- GitHub

---

## Funcționalități implementate

### 1. Model de date
Entități și relații pentru gestionarea spitalului.

---

## Diagramă ERD

Pacient (1) ------ (1) FisaMedicala

Pacient (1) ------ (N) Consultatie

Medic (1) ------ (N)  Consultatie

Sectie (1) ------ (N)  Medic

Pacient (1) ------ (N)  Internare

Sectie (1) ------ (N)  Internare

Consultatie (N)  ------ (N)  Diagnostic

Consultatie  (N)  ------ (N)  Tratament

----

## Entități principale

- Pacient
- Medic
- Secție
- Fișă medicală
- Consultație
- Internare
- Tratament
- Diagnostic

---

## Relații între entități

- Pacient – Fișă medicală: relație OneToOne
- Pacient – Consultație: relație OneToMany / ManyToOne
- Medic – Consultație: relație OneToMany / ManyToOne
- Medic – Secție: relație ManyToOne
- Pacient – Internare: relație OneToMany / ManyToOne
- Secție – Internare: relație OneToMany / ManyToOne
- Consultație – Tratament: relație ManyToMany
- Consultație – Diagnostic: relație ManyToMany

---

### 2. Operații CRUD complete

Aplicația permite operații de tip Create, Read, Update și Delete pentru entitățile principale prin endpoint-uri REST.
## Endpoint-uri testate
- Pacient
- Medic
- Secție
- Fișă Medicală
- Diagnostic
- Tratament
- Consultație
- Internare

Operațiile sunt implementate folosind:
- Spring Boot
- Spring Data JPA
- Repository Pattern
- Service Layer
- REST Controllers

Endpoint-urile au fost testate prin browser și returnează date în format JSON.

---

## 3. Configurare Multi-Environment

Aplicația utilizează profile Spring pentru separarea mediilor de execuție.

Profile implementate:
- dev
- test

Fișiere de configurare:
- application.yml
- application-dev.yml
- application-test.yml

Pentru dezvoltare este utilizată baza de date H2 cu afișarea interogărilor SQL.

---

## 4. Testing

Pentru verificarea funcționalității aplicației au fost implementate teste unitare utilizând JUnit.

Clase testate:
- PacientServiceTest
- DiagnosticServiceTest

Scopul testelor:
- verificarea operațiilor CRUD;
- validarea rezultatelor returnate de servicii;
- verificarea comportamentului aplicației în situații normale și excepționale.

Prin intermediul testelor se asigură funcționarea corectă a logicii aplicației și detectarea rapidă a eventualelor erori.

---

## 5. Views și Validare

Aplicația oferă interfețe pentru afișarea și gestionarea datelor medicale.

Au fost implementate validări pentru câmpurile introduse de utilizator:

### Pacient
- nume obligatoriu;
- prenume obligatoriu;
- CNP obligatoriu;
- telefon obligatoriu.

### Medic
- nume obligatoriu;
- prenume obligatoriu;
- specializare obligatorie.

### Diagnostic
- denumire obligatorie.

### Tratament
- denumire obligatorie.

Validarea datelor previne introducerea informațiilor incomplete sau incorecte și contribuie la menținerea integrității bazei de date.

---

## Gestionarea Excepțiilor

Aplicația utilizează un mecanism centralizat de tratare a excepțiilor prin clasa:

- GlobalExceptionHandler

Scopul acestei componente este interceptarea erorilor apărute în timpul executării aplicației și returnarea unor mesaje clare către utilizator.

Exemple de situații gestionate:

- entitate inexistentă;
- date invalide introduse de utilizator;
- erori de validare;
- resurse care nu pot fi găsite în baza de date.

Beneficii:

- cod mai organizat;
- tratare unitară a erorilor;
- experiență mai bună pentru utilizator;
- depanare mai ușoară a aplicației.

Prin utilizarea mecanismului de excepții centralizate se evită blocarea aplicației și se oferă informații relevante despre cauza erorii.

----

### 6. Logging

Aplicația folosește SLF4J și Logback pentru gestionarea mesajelor de log.

Configurarea se află în fișierul logback-spring.xml.

Sunt utilizate niveluri de logging:
- INFO
- DEBUG
- ERROR

Erorile sunt salvate separat în fișierul logs/errors.log.

---

## 7. Paginare și Sortare

Pentru gestionarea eficientă a volumelor mari de date a fost implementată funcționalitatea de paginare utilizând Pageable din Spring Data JPA.

### Entități cu paginare

- Pacient
- Medic
- Sectie

### Funcționalități implementate

- afișare rezultate pe pagini;
- selectarea dimensiunii paginii;
- navigare între pagini;
- afișare număr total de înregistrări.

### Sortare

Pentru fiecare entitate au fost implementate minimum două criterii de sortare:

#### Pacient
- după nume;
- după prenume.

#### Medic
- după nume;
- după specializare.

#### Sectie
- după denumirea secției;
- după identificator.

Implementarea paginării și sortării îmbunătățește experiența utilizatorului și facilitează accesul rapid la informațiile din sistem.

---

## 8. Spring Security

Aplicația utilizează Spring Security cu autentificare JDBC.

Utilizatorii sunt salvați în baza de date H2 în tabelele:

- users
- authorities

Roluri implementate:

- USER
- ADMIN

Funcționalități:

- autentificare utilizatori
- autorizare pe roluri
- protejare endpoint-uri
- logout funcțional

---

Modelul de date conține 8 entități interconectate. Relațiile importante sunt OneToOne, OneToMany/ManyToOne și ManyToMany, conform cerințelor proiectului.

---

## Studenta 

-Sbârnea (Mihai) Mariana

-IFR-Grupa2

-Master AWBD 2026