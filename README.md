# Hospital Management

Aplicația Hospital Management este o aplicație web realizată în Spring Boot pentru gestionarea activităților dintr-un spital.

## Entități principale

- Pacient
- Medic
- Secție
- Fișă medicală
- Consultație
- Internare
- Tratament
- Diagnostic

## Relații între entități

- Pacient – Fișă medicală: relație OneToOne
- Pacient – Consultație: relație OneToMany / ManyToOne
- Medic – Consultație: relație OneToMany / ManyToOne
- Medic – Secție: relație ManyToOne
- Pacient – Internare: relație OneToMany / ManyToOne
- Secție – Internare: relație OneToMany / ManyToOne
- Consultație – Tratament: relație ManyToMany
- Consultație – Diagnostic: relație ManyToMany

## Funcționalități CRUD

Aplicația permite operații de tip Create, Read, Update și Delete pentru entitățile principale prin endpoint-uri REST.

## Endpoint-uri testate

- /pacienti
- /medici
- /sectii
- /fisemedicale
- /consultatii
- /internari
- /tratamente
- /diagnostice

## Tehnologii folosite

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Lombok

## Diagramă ER



Pacient (1) ------ (1) FisaMedicala

Pacient (1) ------ (N) Consultatie

Medic (1) ------ (N)  Consultatie

Sectie (1) ------ (N)  Medic

Pacient (1) ------ (N)  Internare

Sectie (1) ------ (N)  Internare

Consultatie (N)  ------ (N)  Diagnostic

Consultatie  (N)  ------ (N)  Tratament
## Operații CRUD

Aplicația implementează operațiile Create, Read, Update și Delete pentru entitățile:

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
## Configurare Multi-Environment

Aplicația utilizează profile Spring pentru separarea mediilor de execuție.

Profile implementate:
- dev
- test

Fișiere de configurare:
- application.yml
- application-dev.yml
- application-test.yml

Pentru dezvoltare este utilizată baza de date H2 cu afișarea interogărilor SQL.
Pentru testare este utilizată o configurație separată cu setări specifice mediului de test.

## Logging

Aplicația folosește SLF4J și Logback pentru gestionarea mesajelor de log.

Configurarea se află în fișierul logback-spring.xml.

Sunt utilizate niveluri de logging:
- INFO
- DEBUG
- ERROR

Erorile sunt salvate separat în fișierul logs/errors.log.

## Spring Security

Aplicația folosește Spring Security cu autentificare JDBC.

Utilizatorii sunt salvați în baza de date H2 în tabelele users și authorities.

Roluri implementate:
- USER
- ADMIN

Endpoint-urile sunt protejate în funcție de rol.
Autentificarea se face prin pagina de login generată de Spring Security.
Logout-ul este funcțional.

Modelul de date conține 8 entități interconectate. Relațiile importante sunt OneToOne, OneToMany/ManyToOne și ManyToMany, conform cerințelor proiectului.