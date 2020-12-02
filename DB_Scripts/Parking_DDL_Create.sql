---------------     CREATE DATABASE     ----------------------------------
IF NOT EXISTS(
SELECT * FROM sys.databases WHERE name = 'Parking'
) BEGIN CREATE DATABASE Parking END;

USE Parking;

---------------     CREATE TABLE Personnes     ---------------------------
IF NOT EXISTS (
SELECT * FROM sysobjects WHERE name = 'Personnes' and xtype = 'U'
)
BEGIN
CREATE TABLE Personnes(
	idPersonne int IDENTITY PRIMARY KEY,
	nom VARCHAR(20) NOT NULL,
	prenom VARCHAR(20) NOT NULL
);
END;