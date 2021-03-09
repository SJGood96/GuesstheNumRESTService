package mthree.GuessNumGame.entities;

//@author Spencer Good

import java.util.Objects;

public class Guess {
    private int gameId;
    private String guess;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guess guess1 = (Guess) o;
        return gameId == guess1.gameId && guess.equals(guess1.guess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, guess);
    }
}
