use master
go
--Crear la BD_mihotel
create database BD_boticatomy
--
use BD_boticatomy
go
--
drop database BD_boticatomy

CREATE TABLE USUARIO (
    ID_USU VARCHAR(5) NOT NULL PRIMARY KEY, -- Id Usuario
    NOM_USU NVARCHAR(50) NOT NULL, -- Nombre
    APE_USU NVARCHAR(50) NOT NULL, -- Apellido
    TIP_USU NVARCHAR(50) NOT NULL, -- Tipo Usuario (Cliente, Trabajador)
    TEL_USU VARCHAR(9) NOT NULL, -- Tel�fono
    EMA_USU NVARCHAR(50) NOT NULL, -- E-mail
    CON_USU NVARCHAR(50) NOT NULL -- Contrase�a
);

CREATE TABLE CLIENTE (
    DNI_CLI INT NOT NULL PRIMARY KEY, -- DNI
    ID_USU VARCHAR(5) NOT NULL, -- Id Usuario
    FOREIGN KEY (ID_USU) REFERENCES USUARIO(ID_USU)
);

CREATE TABLE TRABAJADOR (
    DNI_TRA INT NOT NULL PRIMARY KEY, -- DNI
    ID_USU VARCHAR(5) NOT NULL, -- Id Usuario
    FOREIGN KEY (ID_USU) REFERENCES USUARIO(ID_USU)
);

CREATE TABLE MEDICAMENTO (
    ID_MED INT PRIMARY KEY IDENTITY, -- Id Medicamento
    NOM_MED NVARCHAR(100) NOT NULL, -- Nombre
    COD_MED NVARCHAR(50) NOT NULL UNIQUE, -- Codigo
    PRE_MED DECIMAL(10, 2) NOT NULL, -- Precio
    STO_MED INT NOT NULL -- Stock
);

CREATE TABLE VENTA (
    ID_VEN INT PRIMARY KEY IDENTITY, -- Id Venta
    DNI_CLI INT, -- DNI Cliente
    FEC_VEN DATETIME DEFAULT GETDATE(), -- Fecha
    TOT_VEN DECIMAL(10, 2) NOT NULL, -- Total
    FOREIGN KEY (DNI_CLI) REFERENCES CLIENTE(DNI_CLI)
);

CREATE TABLE DETALLE_VENTA (
    ID_DET INT PRIMARY KEY IDENTITY, -- Id Detalle
    ID_VEN INT NOT NULL, -- Id Venta
    ID_MED INT NOT NULL, -- Id Medicamento
    CAN_DET INT NOT NULL, -- Cantidad
    PRE_UNI DECIMAL(10, 2) NOT NULL, -- Precio Unitario
    FOREIGN KEY (ID_VEN) REFERENCES VENTA(ID_VEN),
    FOREIGN KEY (ID_MED) REFERENCES MEDICAMENTO(ID_MED)
);

CREATE TABLE FACTURA (
    ID_FAC INT PRIMARY KEY IDENTITY, -- Id Factura
    ID_VEN INT NOT NULL, -- Id Venta
    FEC_FAC DATETIME DEFAULT GETDATE(), -- Fecha
    TOT_FAC DECIMAL(10, 2) NOT NULL, -- Total
    EST_FAC NVARCHAR(20) DEFAULT 'Pendiente', -- Pendiente o Enviada
    FOREIGN KEY (ID_VEN) REFERENCES VENTA(ID_VEN)
);

CREATE TABLE REPORTE_VENTAS (
    ID_REP INT PRIMARY KEY IDENTITY, -- Id Reporte
    TIP_VEN NVARCHAR(50), -- Tipo Venta
    FEC_REP DATETIME DEFAULT GETDATE(), -- Fecha Generaci�n
    REPORTE NVARCHAR(MAX) -- Puede almacenarse en formato JSON, XML o texto plano
);

--VER TABLAS EN EL LOGIN
SELECT * FROM USUARIO
SELECT * FROM CLIENTE
SELECT * FROM TRABAJADOR

--RESETEAR TABLAS DEL LOGIN
DELETE FROM usuario;
DELETE FROM ADMINISTRADOR;
DELETE FROM CLIENTE;

--INSERTAR TRABAJADOR
INSERT INTO USUARIO (ID_USU, NOM_USU, APE_USU, TIP_USU, TEL_USU, EMA_USU, CON_USU)
VALUES ('1', 'Sergio', 'Chiquinta', 'Trabajador', '967548512', 'serchivera76@gmail.com', 'sergiochiquinta');
INSERT INTO TRABAJADOR (DNI_TRA, ID_USU)
VALUES (71012258, '1');

