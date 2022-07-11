CREATE TABLE cliente(
                        id uuid PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        aniver DATE,
                        cpf VARCHAR(11) unique,
                        email VARCHAR(200) unique
);