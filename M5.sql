CREATE DATABASE modulo5;
USE modulo5;

drop table usuarios;
drop table clientes;
drop table administrativos;
drop table profesionales;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);
INSERT INTO users (username, password)
VALUES ('admin', '1234');
SELECT username,
    password
FROM users;
CREATE TABLE capacitaciones (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rut_cliente VARCHAR (12) NOT NULL,
    dia VARCHAR (10) NOT NULL,
    hora VARCHAR (5) NOT NULL,
    lugar VARCHAR (255) NOT NULL,
    duracion INT NOT NULL,
    cantidad_asistentes INT NOT NULL
);
INSERT INTO capacitaciones (
        rut_cliente,
        dia,
        hora,
        lugar,
        duracion,
        cantidad_asistentes
    )
VALUES (
        '14.400.967-3',
        '10/03/2023',
        '16:30',
        'Salon de Eventos',
        5,
        20
    );
CREATE TABLE usuarios (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    fecha VARCHAR(20),
    run int
);
CREATE TABLE administrativos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    area VARCHAR(50),
    experiencia_previa VARCHAR(20),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);
-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, fecha, run)
VALUES ('Juan', '2022-05-10', 12345678 -9);
-- Insertar datos en la tabla administrativos, relacionados con un usuario existente
INSERT INTO administrativos (area, experiencia_previa, id_usuario)
VALUES ('Administración', '5 años', LAST_INSERT_ID());
SELECT *
FROM administrativos;
SELECT *
FROM usuarios u
    JOIN administrativos a ON u.id_usuario = a.id_usuario;
    
-- Crear la tabla profesionales
CREATE TABLE profesionales (
    id_profesional INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(50),
    fecha_ingreso VARCHAR(20),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, fecha, run)
VALUES ('Mario', '2000-01-01', 12345678);
-- Insertar datos en la tabla profesionales, relacionados con un usuario existente
INSERT INTO profesionales (titulo, fecha_ingreso, id_usuario)
VALUES ('Enfermero', '2022-01-01', LAST_INSERT_ID());

-- Crear la tabla clientes
CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    telefono VARCHAR(20),
    afp VARCHAR(50),
    sistema_salud enum("Fonasa", "Isapre"),
    direccion VARCHAR(100),
    comuna VARCHAR(50),
    id_usuario INT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, fecha, run)
VALUES ('Diego', '1985-05-20', 12345678);
-- Insertar datos en la tabla clientes, relacionados con un usuario existente
INSERT INTO clientes (
        telefono,
        afp,
        sistema_salud,
        direccion,
        comuna,
        id_usuario
    )
VALUES (
        '+123456789',
        'AFP Provida',
        1,
        'Av. Libertador 123',
        'Santiago',
        LAST_INSERT_ID()
    );
    

SELECT * FROM usuarios u JOIN profesionales p ON u.id_usuario = p.id_usuario;
SELECT * FROM usuarios u JOIN clientes c ON u.id_usuario = c.id_usuario;
SELECT * FROM usuarios u JOIN administrativos a ON u.id_usuario = a.id_usuario;
SELECT * FROM usuarios u JOIN administrativos a ON u.id_usuario = a.id_usuario where id = 2;
SELECT * from usuarios;
SELECT * from clientes;
SELECT * from administrativos;