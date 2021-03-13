package mthree.GuessNumGame.DOA;

import mthree.GuessNumGame.TestApplicationConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class GameDaoDBTest {

    @Autowired GameDao dao;

    @Test
    public void testGetAllGames() {
    }

    @Test
    public void testGetAnswer() {
    }

    @Test
    public void testGetGameById() {
    }

    @Test
    public void testAddGame() {
    }

    @Test
    public void testUpdateGame() {
    }

}