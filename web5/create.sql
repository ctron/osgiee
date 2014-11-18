CREATE TABLE BOOKS
(
  ID		NUMERIC			NOT NULL PRIMARY KEY,
  NAME		VARCHAR(128)	NOT NULL
);

INSERT INTO BOOKS
	( ID, NAME )
		values
	( 0, 'The Hitchhiker''s Guide to the Galaxy' );