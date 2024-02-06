CREATE TABLE linha (
	id INT GENERATED ALWAYS AS IDENTITY,
	nome VARCHAR,
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

INSERT INTO pontos_onibus(linhaId, minPrevisao) VALUES
    (1, 10),
    (1, 25),
    (1, 5),
    (1, 30),
    (1, 50),
    (2, 8),
    (2, 20),
    (2, 14),
    (2, 30),
    (3, 8),
    (3, 30),
    (3, 14),
    (4, 80),
    (4, 43),
    (4, 18),
    (4, 34),
    (5, 3),
    (5, 17),
    (5, 24),
    (5, 30),
    (6, 42),
    (6, 18),
    (6, 9),
    (6, 58),
    (7, 8),
    (7, 20),
    (7, 14),
    (7, 30)
;