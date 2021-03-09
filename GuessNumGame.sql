DROP DATABASE GuessNumGame;

CREATE DATABASE GuessNumGame;

USE GuessNumGame;


CREATE TABLE Game (
gameId INT NOT NULL AUTO_INCREMENT,
answer INT NOT NULL,
finished Boolean NOT NULL default false,
PRIMARY KEY (gameId));

CREATE TABLE Round (
roundId INT NOT NULL Primary Key  AUTO_INCREMENT,
guess INT NOT NULL,
gameId INT NOT NULL,
result VARCHAR(7) NOT NULL,
guesstime TIME NOT NULL,
constraint fk_gameId foreign key (gameId) 
references Game (gameId)
);

SELECT * FROM game;

INSERT INTO game (answer, finished) VALUES (1234,false);

INSERT INTO round(gameId, guess, result, guessTime) VALUES(1,1234,'e:0:p:0', current_timestamp());
SELECT * FROM ROUND