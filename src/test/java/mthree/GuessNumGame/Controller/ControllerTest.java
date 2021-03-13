package mthree.GuessNumGame.Controller;


import mthree.GuessNumGame.DOA.GameDaoDB;
import mthree.GuessNumGame.DOA.RoundDaoDB;
import mthree.GuessNumGame.TestApplicationConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class ControllerTest {

    @Autowired
    GameDaoDB dao;
    RoundDaoDB Rdoa;


    @Test
    void create() {
    }

    @Test
    void makeGuess() {
    }

    @Test
    void getAllGames() {
    }

    @Test
    void getGameById() {
    }

    @Test
    void getAllRoundsByGameId() {
    }

    @Test
    void determineResult() {
    }
}