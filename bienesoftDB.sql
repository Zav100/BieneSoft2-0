
-- ==============================================================================
-- 1. CREACION DE LA BASE DE DATOS
-- ==============================================================================
-- DROP DATABASE IF EXISTS bienesoft_db;
-- CREATE DATABASE bienesoft_db;
-- USE bienesoft_db;


-- ============================================================
-- BieneSoft - Modelo de Base de Datos (3FN) - v3 (MySQL / MySQL Workbench)
-- Sistema de Administración: Control de socios y reservas
-- ============================================================

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ============ CATÁLOGOS / LOOKUP TABLES ============

CREATE TABLE rol (
    id_rol       INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol   VARCHAR(30) NOT NULL UNIQUE  -- 'Administrador', 'Socio'
) ENGINE=InnoDB;

CREATE TABLE categoria_socio (
    id_categoria_socio INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria   VARCHAR(40) NOT NULL UNIQUE, -- Alumno, Docente, No Docente, Externo
    requiere_legajo    BOOLEAN NOT NULL DEFAULT FALSE
) ENGINE=InnoDB;

CREATE TABLE medio_pago (
    id_medio_pago INT AUTO_INCREMENT PRIMARY KEY,
    nombre        VARCHAR(30) NOT NULL UNIQUE -- Efectivo, Transferencia, Débito, Crédito
) ENGINE=InnoDB;

CREATE TABLE concepto_pago (
    id_concepto INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(30) NOT NULL UNIQUE -- Cuota Membresía, Alquiler
) ENGINE=InnoDB;

-- ============ USUARIO (credenciales/rol) Y SUBTIPOS ============

CREATE TABLE usuario (
    id_usuario     INT AUTO_INCREMENT PRIMARY KEY,
    id_rol         INT NOT NULL,
    nombre         VARCHAR(60), -- NULL hasta completar el paso 2 del alta (solo aplica a socios)
    apellido       VARCHAR(60),
    email          VARCHAR(120) NOT NULL UNIQUE,
    password_hash  VARCHAR(255) NOT NULL,
    fecha_alta     DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activo         BOOLEAN NOT NULL DEFAULT TRUE,
    CONSTRAINT fk_usuario_rol FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
) ENGINE=InnoDB;

-- Datos propios del socio (se cargan en el paso 2 del alta)
CREATE TABLE socio (
    id_socio            INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario          INT NOT NULL UNIQUE,
    id_categoria_socio  INT NOT NULL,
    dni                 VARCHAR(15) NOT NULL UNIQUE,
    fecha_nacimiento    DATE NOT NULL,
    telefono            VARCHAR(30),
    foto_perfil_url     VARCHAR(255),
    legajo              VARCHAR(20),          -- NULL para categoría Externo
    baja_logica         BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_socio_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_socio_categoria FOREIGN KEY (id_categoria_socio) REFERENCES categoria_socio(id_categoria_socio)
) ENGINE=InnoDB;

-- ============ CARNET DIGITAL ============

CREATE TABLE carnet_digital (
    id_carnet        INT AUTO_INCREMENT PRIMARY KEY,
    id_socio         INT NOT NULL UNIQUE,
    codigo_qr_url        VARCHAR(120) NOT NULL,
    fecha_emision    DATE NOT NULL,
    estado           VARCHAR(20) NOT NULL DEFAULT 'Inactivo', -- Activo / Inactivo
    CONSTRAINT fk_carnet_socio FOREIGN KEY (id_socio) REFERENCES socio(id_socio)
) ENGINE=InnoDB;

-- ============ PAGOS Y SUSCRIPCIÓN (mensual, única modalidad) ============

CREATE TABLE pago (
    id_pago         INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario      INT NOT NULL,
    id_medio_pago   INT NOT NULL,
    id_concepto     INT NOT NULL,
    monto           DECIMAL(10,2) NOT NULL,
    fecha_pago      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_pago_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario),
    CONSTRAINT fk_pago_medio FOREIGN KEY (id_medio_pago) REFERENCES medio_pago(id_medio_pago),
    CONSTRAINT fk_pago_concepto FOREIGN KEY (id_concepto) REFERENCES concepto_pago(id_concepto)
) ENGINE=InnoDB;

CREATE TABLE suscripcion_socio (
    id_suscripcion    INT AUTO_INCREMENT PRIMARY KEY,
    id_socio          INT NOT NULL,
    id_pago           INT NOT NULL UNIQUE, -- 1:1, un pago = una suscripción
    fecha_inicio      DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL, -- fecha_inicio + 30 días
    CONSTRAINT fk_suscripcion_socio FOREIGN KEY (id_socio) REFERENCES socio(id_socio),
    CONSTRAINT fk_suscripcion_pago FOREIGN KEY (id_pago) REFERENCES pago(id_pago)
) ENGINE=InnoDB;

-- ============ INSTALACIONES, TURNOS FIJOS Y TARIFAS ============
CREATE TABLE instalacion (
    id_instalacion  INT AUTO_INCREMENT PRIMARY KEY,
    nombre          VARCHAR(60) NOT NULL,
    descripcion 		TEXT,
    disponible      BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE=InnoDB;

CREATE TABLE turno (
    id_turno        INT AUTO_INCREMENT PRIMARY KEY,
    id_instalacion  INT NOT NULL,
    hora_inicio     TIME NOT NULL,
    hora_fin        TIME NOT NULL,
    CONSTRAINT fk_turno_instalacion FOREIGN KEY (id_instalacion) REFERENCES instalacion(id_instalacion),
    CONSTRAINT chk_turno_horas CHECK (hora_fin > hora_inicio),
    UNIQUE KEY uq_turno_instalacion_hora (id_instalacion, hora_inicio)
) ENGINE=InnoDB;

CREATE TABLE tarifa_alquiler (
    id_tarifa           INT AUTO_INCREMENT PRIMARY KEY,
    id_instalacion      INT NOT NULL,
    id_categoria_socio  INT NOT NULL,
    precio              DECIMAL(10,2) NOT NULL,
    vigente_desde       DATE NOT NULL,
    vigente_hasta       DATE, -- NULL = tarifa vigente actualmente
    CONSTRAINT fk_tarifa_instalacion FOREIGN KEY (id_instalacion) REFERENCES instalacion(id_instalacion),
    CONSTRAINT fk_tarifa_categoria FOREIGN KEY (id_categoria_socio) REFERENCES categoria_socio(id_categoria_socio),
    UNIQUE KEY uq_tarifa_vigencia (id_instalacion, id_categoria_socio, vigente_desde)
) ENGINE=InnoDB;

-- ============ RESERVAS (automáticas, sin reembolso) ============

CREATE TABLE reserva (
    id_reserva                  INT AUTO_INCREMENT PRIMARY KEY,
    id_socio                    INT NOT NULL,
    id_turno                    INT NOT NULL,
    id_tarifa                   INT NOT NULL,
    id_pago                     INT NOT NULL UNIQUE,
    fecha_reserva               DATE NOT NULL, -- día calendario del turno
    fecha_creacion              DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    activa                      BOOLEAN NOT NULL DEFAULT TRUE, -- FALSE al cancelar
    fecha_limite_reprogramacion DATE, -- se completa solo si fue cancelada (hoy + 15 días)
    -- columna generada: solo tiene valor cuando la reserva está activa,
    -- así el índice único de abajo no choca contra reservas canceladas
    turno_activo_key VARCHAR(30) GENERATED ALWAYS AS (
        CASE WHEN activa THEN CONCAT(id_turno, '-', fecha_reserva) ELSE NULL END
    ) STORED,
    CONSTRAINT fk_reserva_socio FOREIGN KEY (id_socio) REFERENCES socio(id_socio),
    CONSTRAINT fk_reserva_turno FOREIGN KEY (id_turno) REFERENCES turno(id_turno),
    CONSTRAINT fk_reserva_tarifa FOREIGN KEY (id_tarifa) REFERENCES tarifa_alquiler(id_tarifa),
    CONSTRAINT fk_reserva_pago FOREIGN KEY (id_pago) REFERENCES pago(id_pago),
    UNIQUE KEY uq_turno_fecha_activa (turno_activo_key)
) ENGINE=InnoDB;

-- Traza cada reprogramación
CREATE TABLE historial_reserva (
    id_historial      INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva        INT NOT NULL,
    id_turno_anterior INT NOT NULL,
    fecha_anterior    DATE NOT NULL,
    motivo            VARCHAR(200),
    fecha_cambio      DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_historial_reserva FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva),
    CONSTRAINT fk_historial_turno FOREIGN KEY (id_turno_anterior) REFERENCES turno(id_turno)
) ENGINE=InnoDB;

-- ============ VALORACIÓN (estilo Uber: puntaje + comentario opcional, 1 por reserva) ============

CREATE TABLE valoracion_reserva (
    id_valoracion    INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva       INT NOT NULL UNIQUE,
    puntaje          TINYINT NOT NULL,
    comentario       TEXT,
    fecha_valoracion DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_valoracion_reserva FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva),
    CONSTRAINT chk_puntaje CHECK (puntaje BETWEEN 1 AND 5)
) ENGINE=InnoDB;

-- ============ ÍNDICES RECOMENDADOS ============
CREATE INDEX idx_reserva_socio ON reserva(id_socio);
CREATE INDEX idx_reserva_fecha ON reserva(fecha_reserva);
CREATE INDEX idx_turno_instalacion ON turno(id_instalacion);
CREATE INDEX idx_suscripcion_vencimiento ON suscripcion_socio(fecha_vencimiento);
CREATE INDEX idx_socio_categoria ON socio(id_categoria_socio);

SET FOREIGN_KEY_CHECKS = 1;

-- ============ INSERTS DE PRUEBA  ============
INSERT INTO rol (nombre_rol) VALUES
('Administrador'),
('Socio');
 
INSERT INTO categoria_socio (nombre_categoria, requiere_legajo) VALUES
('Alumno UNSE', TRUE),
('Docente', TRUE),
('No Docente', TRUE),
('Externo', FALSE);
 
INSERT INTO medio_pago (nombre) VALUES
('Transferencia');
 
INSERT INTO concepto_pago (nombre) VALUES
('Cuota Membresía'),
('Alquiler');


-- ============ 5. INSTALACIONES ============
 
INSERT INTO instalacion (nombre, descripcion, disponible) VALUES
('Cancha de Fútbol 5', 'Cancha con césped sintético con capacidad para equipos de 5v5.',      TRUE), -- id 1
('Cancha de Básquet',  'Cancha con capacidad para equipos de 5v5.',          TRUE), -- id 2
('Cancha de Beach Voley',  'Cancha de arena con capacidad para equipos de 6v6.',          TRUE), -- id 3
('Cancha de Grande',  'Cancha de césped grande para usos multiples (Rugby - Fútbol).',          TRUE), -- id 4
('SUM (Salón de Usos Múltiples)', 'Salón grande para eventos y actividades grupales, cuenta con asador incluido.', TRUE), -- id 5
('Quincho 1',            'Quincho abierto tamaño mediano, cuenta con asador incluido.',          TRUE), -- id 6
('Quincho 2',            'Quincho abierto tamaño mediano, cuenta con asador incluido.',          TRUE), -- id 7
('Quincho 3',            'Quincho abierto tamaño mediano, cuenta con asador incluido.',          TRUE) -- id 8
; 

-- ============ 6. TURNOS FIJOS ============
 
INSERT INTO turno (id_instalacion, hora_inicio, hora_fin) VALUES
(1, '08:00:00', '09:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '09:00:00', '10:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '10:00:00', '11:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '11:00:00', '12:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '12:00:00', '13:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '13:00:00', '14:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '14:00:00', '15:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '15:00:00', '16:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '16:00:00', '17:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '17:00:00', '18:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '18:00:00', '19:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '19:00:00', '20:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '20:00:00', '21:00:00'), -- id 1: Cancha Fútbol 08-09
(1, '21:00:00', '22:00:00'), -- id 1: Cancha Fútbol 08-09
-- TERMINA LOS TURNOS DE CANCHA DE FUTBOL 5

(2, '08:00:00', '09:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '09:00:00', '10:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '10:00:00', '11:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '11:00:00', '12:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '12:00:00', '13:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '13:00:00', '14:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '14:00:00', '15:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '15:00:00', '16:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '16:00:00', '17:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '17:00:00', '18:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '18:00:00', '19:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '19:00:00', '20:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '20:00:00', '21:00:00'), -- id 1: Cancha BASQUET 08-09
(2, '21:00:00', '22:00:00'), -- id 1: Cancha BASQUET 08-09
-- TERMINA LOS TURNOS DE CANCHA DE BASQUET

(3, '08:00:00', '09:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '09:00:00', '10:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '10:00:00', '11:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '11:00:00', '12:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '12:00:00', '13:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '13:00:00', '14:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '14:00:00', '15:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '15:00:00', '16:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '16:00:00', '17:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '17:00:00', '18:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '18:00:00', '19:00:00'), -- id 1: Cancha BEACH VOLEY 
(3, '19:00:00', '20:00:00'), -- id 1: Cancha BEACH VOLEY 08-09
(3, '20:00:00', '21:00:00'), -- id 1: Cancha BEACH VOLEY 08-09
(3, '21:00:00', '22:00:00'), -- id 1: Cancha BEACH VOLEY 08-09
-- TERMINA LOS TURNOS DE CANCHA DE BEACH VOLEY

(4, '08:00:00', '09:00:00'), -- id 1: Cancha GRANDE
(4, '09:00:00', '10:00:00'), -- id 1: Cancha GRANDE
(4, '10:00:00', '11:00:00'), -- id 1: Cancha GRANDE
(4, '11:00:00', '12:00:00'), -- id 1: Cancha GRANDE
(4, '12:00:00', '13:00:00'), -- id 1: Cancha GRANDE 
(4, '13:00:00', '14:00:00'), -- id 1: Cancha GRANDE
(4, '14:00:00', '15:00:00'), -- id 1: Cancha GRANDE
(4, '15:00:00', '16:00:00'), -- id 1: Cancha GRANDE
(4, '16:00:00', '17:00:00'), -- id 1: Cancha GRANDE
(4, '17:00:00', '18:00:00'), -- id 1: Cancha GRANDE
(4, '18:00:00', '19:00:00'), -- id 1: Cancha GRANDE 
(4, '19:00:00', '20:00:00'), -- id 1: Cancha GRANDE
(4, '20:00:00', '21:00:00'), -- id 1: Cancha GRANDE
(4, '21:00:00', '22:00:00'), -- id 1: Cancha GRANDE
-- TERMINA LOS TURNOS DE CANCHA DE GRANDE

(5, '9:00:00', '15:00:00'), -- id 5: SUM 
(5, '17:00:00', '23:00:00'), -- id 5: SUM 
-- TERMINA LOS TURNOS DEl SUM

(6, '9:00:00', '13:00:00'), -- id 6: QUINCHO 1 
(6, '14:00:00', '18:00:00'), -- id 6: QUINCHO 1 
(6, '19:00:00', '23:00:00'), -- id 6: QUINCHO 1 

(7, '9:00:00', '13:00:00'), -- id 7: QUINCHO 2 
(7, '14:00:00', '18:00:00'), -- id 7: QUINCHO 2 
(7, '19:00:00', '23:00:00'), -- id 7: QUINCHO 2 

(8, '9:00:00', '13:00:00'), -- id 8: QUINCHO 3 
(8, '14:00:00', '18:00:00'), -- id 8: QUINCHO 3 
(8, '19:00:00', '23:00:00') -- id 8: QUINCHO 3 

-- TERMINA LOS TURNOS DE LOS QUINCHOS
;





