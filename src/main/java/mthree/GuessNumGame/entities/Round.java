package mthree.GuessNumGame.entities;

//@author Spencer Good


import java.util.List;
import java.util.Objects;
import java.sql.Timestamp;

public class Round {
    public int roundId;
    private Timestamp guessTime;
    private String result;
    private int gameId;
    private String guess;


    public Round() {
        guessTime=new Timestamp(System.currentTimeMillis());
    }


    public Round(int roundId, Timestamp guessTime, String result, int gameId, String guess) {
        this.roundId = roundId;
        this.guessTime = guessTime;
        this.result = result;
        this.gameId = gameId;
        this.guess = guess;
    }



    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getRoundId () { return roundId; }

    public Timestamp getGuessTime(List getRoundForGame) { return guessTime; }

    public void setGuessTime(Timestamp guessTime) { this.guessTime = guessTime; }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }


    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }


    public int getGameId() {
        return gameId;
    }


    public void setGameId(int gameId) { this.gameId = gameId; }

    public int makeGuess(int guess) { return guess; }

    public Object getGuessTime() { return guessTime; }





    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return roundId == round.roundId && gameId == round.gameId && guessTime.equals(round.guessTime) && result.equals(round.result) && guess.equals(round.guess);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundId, guessTime, result, gameId, guess);
    }

}

