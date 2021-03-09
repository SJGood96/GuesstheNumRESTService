package mthree.GuessNumGame.DOA;

//@author Spencer Good

import mthree.GuessNumGame.entities.Guess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Profile("database")
public class GuessDaoDB implements GuessDoa {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Guess> getAllRoundsByGameId(int gameId) {
        try {
            final String SELECT_ROUNDS_BY_GAMEID = "SELECT * FROM round "
                    + "WHERE gameId = ? ORDER BY guess_time";
            List<Guess> guess = jdbc.query(SELECT_ROUNDS_BY_GAMEID, new GuessMapper(), gameId);
            return guess;
        } catch (DataAccessException ex) {
            return null;
        }
    }


    @Override
    public Guess getGameId(int gameId) {
        try {
            final String GET_GAME_ID = "SELECT * FROM round WHERE guessId =?";
            return jdbc.queryForObject(GET_GAME_ID, new GuessMapper(), gameId);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Guess getGuess(Guess guess) {
        try {
            final String GET_GUESS = "SELECT * FROM round";
            return jdbc.queryForObject(GET_GUESS, new GuessMapper(), guess);
        }catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Guess makeGuess(Guess guess) {
        String SQL = "update Guess guess=?";
        Object makeGuess = new Object();
        jdbc.update(SQL, makeGuess);
        return (Guess) makeGuess;
    }


    public static final class GuessMapper implements RowMapper<Guess> {

        @Override
        public Guess mapRow(ResultSet rs, int index) throws SQLException {
            Guess guess = new Guess();

            guess.setGuess(rs.getString("guess"));

            Timestamp timestamp = rs.getTimestamp("guessTime");
            return guess;

        }
    }
}
