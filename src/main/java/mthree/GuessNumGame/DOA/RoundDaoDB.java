package mthree.GuessNumGame.DOA;

//@author Spencer Good


import mthree.GuessNumGame.entities.Guess;
import mthree.GuessNumGame.entities.Round;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
@Profile("database")
public class RoundDaoDB implements RoundDao {
    private final JdbcTemplate jdbcTemplate;
    private List Current_TimeStamp;

    public RoundDaoDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Round getRoundById(int gameId) {
            final String SELECT_ROUNDS_BY_ID = "SELECT * FROM round WHERE gameId = ? ORDER BY guessTime";
           jdbcTemplate.query(SELECT_ROUNDS_BY_ID, new RoundMapper(), gameId);
            return null;
        }


    @Override
    @Transactional
    public Round addRound(Round round, Guess guess) {
        final String INSERT_ROUND = "INSERT INTO round(gameId, guess, result, guessTime) VALUES(?,?,?,?)";
        jdbcTemplate.update(INSERT_ROUND, round.getGameId(), round.getGuess(), round.getResult(), round.getGuessTime());

        int newRoundId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setRoundId(newRoundId);
        return round;
    }


    @Override
    public Object getGuessTime(List getRoundForGame) {
        final String INSERT_ROUND = "SELECT * FROM Round WHERE guessTime";
        jdbcTemplate.update(INSERT_ROUND, getRoundForGame);
        return null;
    }


    @Override
    public List<Round> getGameById(int gameId) {
        final String SELECT_ROUND = "SELECT * FROM round WHERE gameId";
        jdbcTemplate.queryForObject(SELECT_ROUND, new RoundMapper(), gameId);
        return null;
    }


    @Override
    public List<Round> getAllRoundsByGameId(int gameId) {
            final String SELECT_ROUNDS_BY_GAMEID = "SELECT * FROM round WHERE gameId = ? ORDER BY guessTime";
           return jdbcTemplate.query(SELECT_ROUNDS_BY_GAMEID, new RoundMapper(), gameId);
        }


    @Override
    public Round makeGuess(Round guess) {
        String SQL = "update Guess guess=?";
        Object makeGuess = new Object();
        jdbcTemplate.update(SQL, makeGuess);
        return (Round) makeGuess;
    }

    @Override
    public Round addRound(Round round) {
        return null;
    }

    @Override
    public int getGameId() {
        return 0;
    }

    @Override
    public int getRoundId() {
        return 0;
    }

    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundId(rs.getInt("roundId"));
            round.setResult(rs.getString("result"));
            round.setGuess(rs.getString("guess"));

            round.setResult(rs.getString("result"));
            return round;
        }
    }
}