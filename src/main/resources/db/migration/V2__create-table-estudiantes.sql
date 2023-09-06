
CREATE TABLE IF NOT EXISTS estudiantes(
    id INT AUTO_INCREMENT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    documento VARCHAR(20) NOT NULL,
    edad INT,
    numero_de_ficha VARCHAR(50) NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(numero_de_ficha) REFERENCES ficha(numero)
    )

