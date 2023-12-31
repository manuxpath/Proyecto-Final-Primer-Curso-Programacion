DROP DATABASE IF EXISTS PROYECTOBOMBEROS;
CREATE DATABASE PROYECTOBOMBEROS;
USE PROYECTOBOMBEROS;



CREATE TABLE EMERGENCIAS(
	ID INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    Nombre VARCHAR(25) UNIQUE,
    Prioridad VARCHAR(5),
    Tipo VARCHAR(50),
    Descripcion VARCHAR(240),
    NombreCreador VARCHAR(20),
    Estado VARCHAR(50),
    Idioma VARCHAR(3),
    CHECK(Idioma='ESP' OR Idioma='JP'),
    CHECK(Estado='Finalizado' OR Estado="En curso" OR Estado="Sin seleccionar" OR Estado='終了' OR Estado='進行中' OR Estado='未選択'),
    ID_Usuario INT
);

CREATE TABLE USUARIOS(
	ID INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    USUARIO VARCHAR(20) UNIQUE NOT NULL,
    CONTRA VARCHAR(250) NOT NULL,
    EMAIL VARCHAR(150),
    RANGO VARCHAR(45),
    SEXO VARCHAR(6),
    PAIS VARCHAR(3),
    MENSAJE1 VARCHAR(240),
    MENSAJE2 VARCHAR(240),
    MENSAJE3 VARCHAR(240),
    USER1 VARCHAR(20),
    USER2 VARCHAR(20),
    USER3 VARCHAR(20),
    SEXOUSER1 VARCHAR(20),
    SEXOUSER2 VARCHAR(20),
    SEXOUSER3 VARCHAR(20),
    CHECK(PAIS='JP' OR PAIS='ESP'),
    SALARIO DECIMAL(9,2),
    HORASVOLUNTARIO INT,
    ID_Caso INT,
    FOREIGN KEY (ID_Caso) REFERENCES EMERGENCIAS(ID)
);

CREATE TABLE MENSAJES(
ID INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
Mensaje VARCHAR(255),
NombreUsuarioEnviado VARCHAR(20),
NombreUsuarioRecibido VARCHAR(20),
ID_Usuario INT,
Tiempo TIMESTAMP,
FOREIGN KEY(ID_Usuario) REFERENCES USUARIOS(ID)
);

ALTER TABLE EMERGENCIAS
	ADD FOREIGN KEY(ID_Usuario) REFERENCES USUARIOS(ID);