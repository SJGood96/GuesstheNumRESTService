package mthree.GuessNumGame.entities;


//@author Spencer Good

import java.util.Objects;

public class Game {
    private static int gameId;
    private static boolean finished;
    private String answer;

    public Game() {
    }

    public int getGameId()
    {
        return gameId;
    }

    public void setGameId(int gameId)
    {
        this.gameId = gameId;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public static boolean isFinished()
    {
        return finished;
    }

    public boolean setFinished(boolean finished)
    {
        this.finished = finished;
        return finished;
    }
    public void setAnswer() {
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return answer.equals(game.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answer);
    }

}
