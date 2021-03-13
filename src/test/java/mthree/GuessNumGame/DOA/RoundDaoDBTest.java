package mthree.GuessNumGame.DOA;


import mthree.GuessNumGame.TestApplicationConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class RoundDaoDBTest {

    @Autowired RoundDao Rdao;


    @org.junit.jupiter.api.Test
    public void testGetRoundById() {
    }

    @org.junit.jupiter.api.Test
    public void testAddRound() {
    }

    @org.junit.jupiter.api.Test
    public void testGetGuessTime() {
    }

    @org.junit.jupiter.api.Test
    public void testGetGameById() {
    }

    @org.junit.jupiter.api.Test
    public void testGetAllRoundsByGameId() {
    }

    @org.junit.jupiter.api.Test
    public void testMakeGuess() {
    }

}