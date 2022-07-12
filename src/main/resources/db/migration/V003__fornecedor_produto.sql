CREATE TABLE fornecedor(
                        id uuid PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        aniver DATE,
                        cnpj VARCHAR(14) unique
);


CREATE TABLE produto(
                           id uuid PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           valor numeric(10,2) NOT NULL
);

CREATE TABLE fornecedor_produto(
        fornecedor_id uuid references fornecedor(id),
        produto_id uuid references produto(id),
        primary key (fornecedor_id, produto_id)
)