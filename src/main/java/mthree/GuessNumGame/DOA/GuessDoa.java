package mthree.GuessNumGame.DOA;

//@author Spencer Good

import mthree.GuessNumGame.entities.Guess;

import java.util.List;


public interface GuessDoa {

    Guess getGameId(int gameId);
    Guess getGuess(Guess guess);

    Guess makeGuess(Guess guess);
    List<Guess> getAllRoundsByGameId(int gameId);
}
