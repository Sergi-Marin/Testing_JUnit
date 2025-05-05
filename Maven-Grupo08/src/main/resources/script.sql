CREATE DATABASE maven_bbdd;
USE maven_bbdd;
CREATE TABLE Vehiculos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(50) NOT NULL,
    estado ENUM('Disponible', 'Alquilado', 'Mantenimiento', 'Fuera de servicio') NOT NULL DEFAULT 'Disponible',
    precio_por_dia DECIMAL(7,2) NOT NULL
);

CREATE TABLE Clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    telefono VARCHAR(15),
    dni VARCHAR(20)
);

CREATE TABLE Oficinas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ciudad VARCHAR(50),
    direccion VARCHAR(100),
    telefono VARCHAR (15)
);
