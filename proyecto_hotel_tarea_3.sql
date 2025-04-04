DROP DATABASE IF EXISTS proyecto_hotel;
CREATE DATABASE proyecto_hotel;
USE proyecto_hotel;

CREATE TABLE huespedes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    identidad VARCHAR(50) UNIQUE NOT NULL,
    activo TINYINT(1) DEFAULT 1
);

CREATE TABLE tipo_habitaciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    capacidad INT NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE habitaciones (
	id INT AUTO_INCREMENT PRIMARY KEY,
    numero_habitacion VARCHAR(50) NOT NULL,
    tipo_habitacion_id INT NOT NULL,
    activo TINYINT(1) DEFAULT 1,
    FOREIGN KEY (tipo_habitacion_id) REFERENCES tipo_habitaciones(id)
);

CREATE TABLE estados_reserva (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_estado VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE reservas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    huesped_id INT NOT NULL,
    habitacion_id INT NOT NULL,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    estado_reserva_id INT NOT NULL,
    precio DECIMAL(10,2) NOT NULL, 
    activo TINYINT(1) DEFAULT 1, 
    FOREIGN KEY (huesped_id) REFERENCES huespedes(id),
    FOREIGN KEY (habitacion_id) REFERENCES habitaciones(id),
    FOREIGN KEY (estado_reserva_id) REFERENCES estados_reserva(id)
);

CREATE TABLE metodos_pago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_metodo VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE pagos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    reserva_id INT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    metodo_pago_id INT NOT NULL,
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    activo TINYINT(1) DEFAULT 1,
    FOREIGN KEY (reserva_id) REFERENCES reservas(id),
    FOREIGN KEY (metodo_pago_id) REFERENCES metodos_pago(id)
);

CREATE TABLE cargos_empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_cargo VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    cargo_id INT NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    salario DECIMAL(10,2) NOT NULL,
    activo TINYINT(1) DEFAULT 1,
    FOREIGN KEY (cargo_id) REFERENCES cargos_empleados(id)
);

ALTER TABLE cargos_empleados ADD COLUMN activo TINYINT(1) DEFAULT 1;
ALTER TABLE empleados ADD COLUMN contrasena VARCHAR(255) NOT NULL;

INSERT INTO huespedes (nombre, apellido, correo, telefono, identidad) VALUES 
("Jahdiel", "Lopez", "jahdiel.lopez@gmail.com", "96210760", "0501-2003-15000"),
('Sofia', 'Gomez', 'sofia.gomez@gmail.com', '98765432', '0501-1997-12000'),
('Luis', 'Padilla', 'luis.padilla@gmail.com', '88904312', '0501-2000-11000');

INSERT INTO tipo_habitaciones (tipo, capacidad, descripcion) VALUES
('Doble', 2, 'Habitacion con dos camas individuales'),
('Familiar', 4, 'Habitacion amplia para toda la familia'),
('Individual', 1, 'Habitacion con una cama individual');

INSERT INTO habitaciones (numero_habitacion, tipo_habitacion_id) VALUES
('A1', 1),
('B1', 2),
('C1', 3);


INSERT INTO estados_reserva (nombre_estado) VALUES
('Pendiente'),
('Confirmada'),
('Cancelada'),
('Finalizada');

INSERT INTO reservas (huesped_id, habitacion_id, fecha_entrada, fecha_salida, estado_reserva_id, precio) VALUES
(1, 1, '2025-03-10', '2025-03-15', 2, 150.00),
(2, 2, '2025-04-01', '2025-04-05', 1, 120.00),
(3, 3, '2025-05-15', '2025-05-20', 2, 200.00);

INSERT INTO metodos_pago (nombre_metodo) VALUES
('Tarjeta de Credito'),
('Efectivo'),
('Transferencia Bancaria');

INSERT INTO pagos (reserva_id, monto, metodo_pago_id) VALUES
(1, 150.00, 1),
(2, 120.00, 2),
(3, 200.00, 3);

INSERT INTO cargos_empleados (nombre_cargo) VALUES
('Recepcionista'),
('Gerente');

INSERT INTO empleados (nombre, apellido, cargo_id, correo, telefono, salario, contrasena) VALUES
('Kevin', 'Lopez', 1, 'kevin.lopez@gmail.com', '87654312', 1200.00, '$2a$10$KRO9gI.55aZ4BTw.NJ4YiOQokKV5iKoosFPJvwndyUWQl/UYD1nX.'), -- kl2025
('Mauricio', 'Escalante', 2, 'mauricio.escalante@gmail.com', '91234567', 2500.00, '$2a$10$bBp3rgr6L7s0DKWDhHrbhuHc8Js/Jigsk8835ZWoAB5UQuz6.NoPa'), -- me2025
('Victor', 'Rodriguez', 2, 'victor.rodriguez@gmail.com', '90126789', 1100.00, '$2a$10$QiZWvQ5eVE3dJDmBskCTdukKRsFG4cKOh4mLRHVDCjyDatKVCl9c6'); -- vr2025
