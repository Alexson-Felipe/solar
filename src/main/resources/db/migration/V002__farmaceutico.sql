CREATE TABLE farmaceutico(
                        id uuid PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        aniver DATE,
                        cpf VARCHAR(11) unique,
                        promocao_dia VARCHAR(200) unique
);