CREATE TABLE linha (
	id INT GENERATED ALWAYS AS IDENTITY,
	nome VARCHAR,
    lotacao INT DEFAULT 40,
    gastoPorKm NUMERIC DEFAULT 0.00,
	PRIMARY KEY(id)
);

CREATE TABLE pontos_onibus (
	id INT,
	linhaId INT,
	minPrevisao INT,
	PRIMARY KEY(id, linhaId),
   CONSTRAINT fk_linha_onibus
      FOREIGN KEY(linhaId) 
        REFERENCES linha(id)
);

INSERT INTO linha(nome)  VALUES
    ('Campolim'),
    ('UFSCar'),
    ('Wanel ville'),
    ('Novo mundo'),
    ('Prefeitura'),
    ('Vitoria regia'),
    ('Sao bento')
;

INSERT INTO pontos_onibus(id, linhaId, minPrevisao) VALUES
    (1, 1, 10),
    (2, 1, 25),
    (3, 1, 5),
    (4, 1, 30),
    (5, 1, 50),
    (2, 2, 8),
    (4, 2, 20),
    (3, 2, 14),
    (6, 2, 30),
    (1, 3, 8),
    (3, 3, 30),
    (2, 3, 14),
    (1, 4, 80),
    (4, 4, 43),
    (3, 4, 18),
    (5, 4, 34),
    (5, 5, 3),
    (3, 5, 17),
    (2, 5, 24),
    (4, 5, 30),
    (1, 6, 42),
    (2, 6, 18),
    (3, 6, 9),
    (4, 6, 58),
    (4, 7, 8),
    (5, 7, 20),
    (6, 7, 14),
    (1, 7, 30)
;