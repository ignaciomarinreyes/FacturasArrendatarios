DROP DATABASE IF EXISTS alquileres;
CREATE DATABASE alquileres;

use alquileres;

/*ALTER TABLE registroFactura DROP FOREIGN KEY registrofactura_ibfk_1;
ALTER TABLE registroFactura DROP FOREIGN KEY registrofactura_ibfk_2;*/

CREATE TABLE arrendatario(
	dni VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(60) NOT NULL,
	apellidos VARCHAR(60)
);

CREATE TABLE inmueble(
	idInmueble int PRIMARY KEY AUTO_INCREMENT,
	nombreCalle VARCHAR(60) NOT NULL,
	numeroCalle VARCHAR(10) NOT NULL,
	localidad VARCHAR(60) NOT NULL,
	numeroInmueble VARCHAR(4) ,
	tipoInmueble VARCHAR(60) NOT NULL
);

CREATE TABLE contrato(
	idContrato  int PRIMARY KEY AUTO_INCREMENT,
    dniArrendatario VARCHAR(9), 
    idInmueble  int NOT NULL,
    duracionContrato int NOT NULL DEFAULT 5,
	precio1Inmueble double NOT NULL,
    precio2Inmueble double,
    FOREIGN KEY (dniArrendatario) REFERENCES arrendatario(dni) ON DELETE CASCADE,
    FOREIGN KEY (idInmueble) REFERENCES inmueble(idInmueble) ON DELETE CASCADE
);

CREATE TABLE registroFactura(
	PRIMARY KEY (idRegistroFactura, dniArrendatario, idInmueble, numeroFactura, idContrato),
    idRegistroFactura int  AUTO_INCREMENT,
	dniArrendatario  VARCHAR(9)  NOT NULL,
    idInmueble int NOT NULL,
    numeroFactura int NOT NULL,
    fechaFactura  date NOT NULL,
    cobrado boolean NOT NULL,
    agua boolean NOT NULL,
    luz boolean NOT NULL,
    idContrato int NOT NULL,    
    FOREIGN KEY (idContrato) REFERENCES contrato(idContrato) ON DELETE CASCADE,
    FOREIGN KEY (dniArrendatario) REFERENCES arrendatario(dni) ON DELETE CASCADE,
    FOREIGN KEY (idInmueble) REFERENCES inmueble(idInmueble) ON DELETE CASCADE
);

CREATE TABLE cobro(
	PRIMARY KEY (idCobro, idRegistroFactura),
    idCobro int AUTO_INCREMENT,
    idRegistroFactura int NOT NULL,
    fechaCobro date NOT NULL,
    importe double NOT NULL,
    FOREIGN KEY (idRegistroFactura) REFERENCES registroFactura(idRegistroFactura) ON DELETE CASCADE
);

CREATE TABLE configuracion(
	PRIMARY KEY (idConfiguracion),
    idConfiguracion int,
    irpf float,
    igic float
);

CREATE TABLE arrendador(
	idArrendador int PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(60) NOT NULL,
	apellidos VARCHAR(60) NOT NULL,
	nacionalidad VARCHAR(60) NOT NULL,
	nombreCalle VARCHAR(60) NOT NULL,
	numeroCalle VARCHAR(60) NOT NULL,
	localidad VARCHAR(60) NOT NULL,
	municipio VARCHAR(60) NOT NULL,
	dni VARCHAR(9) NOT NULL,
	email VARCHAR(60) NOT NULL
);

ALTER TABLE inmueble ADD COLUMN letraInmueble VARCHAR(4);

ALTER TABLE arrendatario ADD COLUMN nacionalidad VARCHAR(20) NOT NULL;
ALTER TABLE arrendatario ADD COLUMN nombreCalle VARCHAR(20) NOT NULL;
ALTER TABLE arrendatario ADD COLUMN numeroCalle VARCHAR(10) NOT NULL;
ALTER TABLE arrendatario ADD COLUMN localidad VARCHAR(20) NOT NULL;
ALTER TABLE arrendatario ADD COLUMN municipio VARCHAR(20) NOT NULL;

ALTER TABLE contrato ADD COLUMN idArrendador int NOT NULL;
ALTER TABLE contrato ADD FOREIGN KEY (idArrendador) REFERENCES arrendador(idArrendador) ON DELETE CASCADE;
ALTER TABLE contrato ADD COLUMN inicioContrato date NOT NULL;

ALTER TABLE arrendador ADD COLUMN codigoPostal VARCHAR(5) NOT NULL;
