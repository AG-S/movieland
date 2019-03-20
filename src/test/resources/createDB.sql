CREATE SCHEMA IF NOT EXISTS movieland;
SET SCHEMA movieland;
DROP TABLE IF EXISTS  movies;

CREATE TABLE IF NOT EXISTS movies
(
	id  INTEGER IDENTITY PRIMARY KEY,
	namerussian varchar(64),
	namenative varchar(64),
	yearofrelease number(4),
	rating double precision default 0,
	price double precision default 0,
	picturepath  varchar(256)
)
;
