USE Parking;

DELETE FROM Personnes;
DBCC CHECKIDENT (Personnes, RESEED, 0);