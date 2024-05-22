CREATE TABLE imovel (
    id SERIAL PRIMARY KEY,
    endereco VARCHAR(255) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    area NUMERIC(10, 2) NOT NULL
);

INSERT INTO imovel (endereco, preco, area) VALUES
('Rua 1, 123', 100000.00, 100.00),
('Rua 2, 456', 200000.00, 200.00),
('Rua 3, 789', 300000.00, 300.00);