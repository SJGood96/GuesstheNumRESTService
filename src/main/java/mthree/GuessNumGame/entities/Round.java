package mthree.GuessNumGame.entities;

//@author Spencer Good


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.sql.Timestamp;

public class Round<guess> {
    public int roundId;
    public List getRoundForGame;
    private LocalDateTime guessTime;
    private String result;
    private int gameId;


    public Round() {
    }


    public Round(int roundId, LocalDateTime guessTime, String result) {
        this.roundId = roundId;
        this.guessTime = guessTime;
        this.result = result;
    }


    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }


    public LocalDateTime getGuessTime(List getRoundForGame) {
        return guessTime;
    }

    public void setGuessTime(LocalDateTime guessTime) {
        this.guessTime = guessTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setGuess(String guess) {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round<?> round = (Round<?>) o;
        return roundId == round.roundId && guessTime.equals(round.guessTime) && result.equals(round.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundId, guessTime, result);
    }

    public int getGameId() {
        return gameId;
    }

    public String getGuess() {
        return null;
    }

    public void setGameId(int gameId) { this.gameId = gameId; }


    public  Timestamp getGuessTime() { return null; }
}

