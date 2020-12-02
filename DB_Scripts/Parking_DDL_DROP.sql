USE Parking
IF EXISTS (
	SELECT * FROM sys.databases WHERE name = 'Parking'
) BEGIN USE Parking END;

---------------     DROP TABLE Personnes     -------------------------
IF EXISTS (
SELECT * FROM sysobjects WHERE name = 'Personnes' and xtype = 'U'
)
BEGIN DROP TABLE Personnes END;

---------------     DROP DATABASE     ----------------------------------
IF EXISTS(
SELECT * FROM sys.databases WHERE name = 'Parking'
) BEGIN 
USE master;
ALTER DATABASE Parking SET OFFLINE WITH ROLLBACK IMMEDIATE;
ALTER DATABASE Parking SET ONLINE;
DROP DATABASE Parking;
END;