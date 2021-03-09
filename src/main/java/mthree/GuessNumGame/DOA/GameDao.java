package mthree.GuessNumGame.DOA;

//@author Spencer Good


import mthree.GuessNumGame.entities.Game;

import java.util.List;

public interface GameDao {

    static GameDao findGameById(int gameId) {
        return null;
    }

    List<Game> getAllGames();

    String getAnswer(int gameId);
    Game getGameById(int gameId);
    Game addGame(Game game);
    boolean updateGame(Game round);

    int setAnswer(String hideAnswer);

    boolean setFinished(boolean b);


}
