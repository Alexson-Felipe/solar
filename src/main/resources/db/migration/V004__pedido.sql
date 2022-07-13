CREATE TABLE pedido(
                        id uuid PRIMARY KEY,
                        farmaceutico_id uuid references farmaceutico(id),
                        cliente_id uuid references  cliente(id),
                        valor NUMERIC(10,2) not null,
                        valor_pago NUMERIC(10,2),
                        troco NUMERIC(10,2),
                        data_emissao TIMESTAMP not null default now(),
                        data_pagamento TIMESTAMP,
                        data_cancelamento TIMESTAMP,
                        status VARCHAR not null
);

CREATE TABLE pedido_produto(
    pedido_id UUID REFERENCES  pedido(id),
    produto_id UUID references  produto(id),
    PRIMARY KEY (pedido_id, produto_id)
);

