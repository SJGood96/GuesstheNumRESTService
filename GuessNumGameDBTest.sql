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
gameId INT NOT NULL,
result INT NOT NULL,
guesstime TIME NOT NULL,
constraint fk_gameId foreign key (gameId) 
references Game (gameId)
);

CREATE TABLE GUESS (
guess INT NOT NULL PRIMARY KEY,
guessTime DATETIME NOT NULL,
gameId INT NOT NULL,
CONSTRAINT fk_guess_gameId foreign key (gameId) 
references Game (gameId)
);