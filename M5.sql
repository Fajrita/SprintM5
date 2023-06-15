CREATE DATABASE M5;
USE  M5;

CREATE TABLE users (
username VARCHAR(255) NOT NULL,
password VARCHAR (255) NOT NULL);

INSERT INTO users(username, password) VALUES
('admin', '1234');

SELECT * FROM users;


CREATE TABLE capacitaciones ( 
id INT PRIMARY KEY AUTO_INCREMENT,
rut_cliente VARCHAR (12) NOT NULL,
dia VARCHAR (10) NOT NULL,
hora VARCHAR (5) NOT NULL,
lugar VARCHAR (255) NOT NULL,
duracion INT NOT NULL,
cantidad_asistentes INT NOT NULL);

INSERT INTO capacitaciones (rut_cliente, dia, hora, lugar, duracion, cantidad_asistentes) VALUES
('14.400.967-3', '10/03/2023', '16:30', 'Salon de Eventos', 5, 20);

SELECT * FROM capacitaciones;

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, fecha, run)
VALUES ('Juan', '2022-05-10', 12345678-9);

-- Insertar datos en la tabla administrativos, relacionados con un usuario existente
INSERT INTO administrativos (area, experiencia_previa, id_usuario)
VALUES ('Administración', '5 años', LAST_INSERT_ID());

select * from administrativos;
SELECT * FROM usuarios u JOIN administrativos a ON u.id_usuario = a.id_usuario





