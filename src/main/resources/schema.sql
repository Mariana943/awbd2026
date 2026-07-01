--Crearea tabelului users
CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY, --Numele utilizatorului (cheie primara)
                       password VARCHAR(100) NOT NULL, --Parola utilizatorului
                       enabled BOOLEAN NOT NULL -- Indica daca utilizatorul este activ
);

--Crearea tabelului authorities
CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL, --Numele utilizatorului
                             authority VARCHAR(50) NOT NULL,--Rolul utilizatorului (ROLE_USER sau ROLE_ADMIN)
                             CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username) --Legatura dintre tabelul authorities și users
);