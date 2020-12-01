-------------     CREATE USER     -----------------------------------

SELECT * FROM master.sys.server_principals;

SELECT * FROM sysusers;

CREATE LOGIN student WITH PASSWORD = 'student';

CREATE USER student FOR LOGIN student;

USE parking GRANT ALL PRIVILEGES TO student;

EXECUTE AS USER = 'student';
SELECT * FROM fn_my_permissions(NULL, 'DATABASE');
SELECT * FROM fn_my_permissions(NULL, 'SERVER');
REVERT;


------------     CREATE DATABASE     -------------------------------------

CREATE DATABASE parking;

CREATE TABLE test (
	id int
);

DROP TABLE test;