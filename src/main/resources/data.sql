--Adaugarea utilizatorului normal în baza de date
INSERT INTO users (username, password, enabled)
VALUES ('user', '{noop}user123', true);

--Adaugarea administratorului
INSERT INTO users (username, password, enabled)
VALUES ('admin', '{noop}admin123', true);

--Atribuirea rolului ROLE_USER utilizatorului normal
INSERT INTO authorities (username, authority)
VALUES ('user', 'ROLE_USER');

--Atribuirea rolului ROLE_ADMIN administratorului
INSERT INTO authorities (username, authority)
VALUES ('admin', 'ROLE_ADMIN');