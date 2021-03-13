package mthree.GuessNumGame.Controller;

//@author Spencer Good



import mthree.GuessNumGame.DOA.GameDao;
import mthree.GuessNumGame.DOA.RoundDao;
import mthree.GuessNumGame.entities.Game;
import mthree.GuessNumGame.entities.Guess;
import mthree.GuessNumGame.entities.Round;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping ("api/Game")
public class Controller<gameId> {


    private final GameDao doa;
    private final RoundDao Rdoa;

    public Controller(GameDao doa, RoundDao Rdoa) {
        this.doa = doa;
        this.Rdoa = Rdoa;
    }

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int create() {
        //This gets the generated answer
        Game game = new Game();
        game.setAnswer(generateAnswer());

        game = doa.addGame(game);//Sets the game in the database



        return game.getGameId(); //This returns the gameId for the user
    }

    @PostMapping("/guess")
    public Round makeGuess(int gameId, String guess, Timestamp guessTime) {
        Guess g = new Guess();
        Round round = new Round();
        round.setGameId(gameId);
        g.setGuess(guess);

        round.setGuess(guess);
        round.setGuessTime(new Timestamp(System.currentTimeMillis()));

        Game x = doa.getGameById(round.getGameId());
        String answer = x.getAnswer();
        String result = determineResult(guess, answer);
        round.setResult(result);

        //If the guess is equal to the answer then the game is finished
        if (answer.equals(g.getGuess())) {
            Game game = doa.getGameById(round.getGameId());;
            game.setFinished(true);
            doa.updateGame(game);
        }

        return Rdoa.addRound(round, g);
    }

    //This will show all the games that are in the database. It will hide the answer if the
    //game is still being played.
    @GetMapping("/games")
    public List<Game> getAllGames() {
        List<Game> games = doa.getAllGames();
        for (Game game : games) {
            if (!game.isFinished()) {
                game.setAnswer("****");
            }
        }

        return games;
    }


    //This returns a certain game by its id and if the game is finished it will hide the answer.
    @GetMapping("/game/{gameId}")

    public Object getGameById(@PathVariable("gameId") int gameId) {
        Game game = doa.getGameById(gameId);
        if (!game.isFinished()) {
            game.setAnswer("****");

            if (game == null) {
                return new ResponseEntity(null, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity(game, HttpStatus.OK);

        }

        return doa.getGameById(gameId);


    }


    //This returns the rounds of a certain game by it's id along with
    //sorting the rounds by guessTime.
    @GetMapping("/rounds/{gameId}")
    public Object getAllRoundsByGameId (@PathVariable("gameId") int gameId) {
        List<Round> rounds = Rdoa.getAllRoundsByGameId(gameId);

            if (rounds == null) {
            return  new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity(rounds, HttpStatus.OK);
    }



    //This method uses random to draw a specific number between zero and the specific value which in this
//case would be 9 since we want to draw numbers between 0 and 9.
//This also makes sure that the numbers are not the same as the last number in the sequence.
    private String generateAnswer(){
        Random rnd = new Random();
        int digit1 = rnd.nextInt(8)+1;

        int digit2 = rnd.nextInt(9);
        while (digit2 == digit1) {
            digit2 = rnd.nextInt(9);
        }

        int digit3 = rnd.nextInt(9);
        while ((digit3 == digit2) || (digit3 == digit1)) {
            digit3=rnd.nextInt(9);
        }

        int digit4 = rnd.nextInt(9);
        while ((digit4 == digit3) || (digit4 == digit2) || (digit4 == digit1)) {
            digit4=rnd.nextInt(9);
        }

        //This equation adds the vaules of the four random numbers to create the secret number.

        String answer = String.valueOf(digit1) + digit2
                + digit3 + digit4;



        return answer;
    }

    private void hideAnswer(Game gameToReturn) {
        if (gameToReturn.isFinished() == false) {
            gameToReturn.setAnswer("****");
        }
    }
    public String determineResult(String guess, String answer) {
        char[] guessChars = guess.toCharArray();
        char[] answerChars = answer.toCharArray();
        int exact = 0;
        int partial = 0;

        for (int i = 0; i < guessChars.length; i++) {
            // -1 indicates that index value of guessChars DNE in answer
            // otherwise the number must be in the string. Then check where
            if (answer.indexOf(guessChars[i]) > -1) {
                if (guessChars[i] == answerChars[i]) {
                    exact++;
                } else {
                    partial++;
                }
            }
        }

        String result = "e:" + exact + ":p:" + partial;

        return result;
    }

}
