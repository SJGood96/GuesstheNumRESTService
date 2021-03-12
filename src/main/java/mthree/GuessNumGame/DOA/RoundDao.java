package mthree.GuessNumGame.DOA;

//@author Spencer Good


import mthree.GuessNumGame.entities.Guess;
import mthree.GuessNumGame.entities.Round;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface RoundDao {

    static RoundDao getRoundForGame(int gameId) {
        return null;
    }

    Round getRoundById(int roundId);
    Round addRound(Round round, Guess guess);

    Object getGuessTime(List getRoundForGame);

    List<Round> getGameById(int gameId);

    List<Round> getAllRoundsByGameId(int gameId);

    Round addRound(Round round);
    public int getGameId();

    public Round makeGuess (Round guess);

    int getRoundId();
}
