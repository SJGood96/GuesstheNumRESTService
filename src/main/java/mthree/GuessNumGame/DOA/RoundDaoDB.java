package mthree.GuessNumGame.DOA;

//@author Spencer Good


import mthree.GuessNumGame.entities.Guess;
import mthree.GuessNumGame.entities.Round;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Profile("database")
public class RoundDaoDB implements RoundDao {
    private final JdbcTemplate jdbcTemplate;
    private List Current_TimeStamp;


    @Autowired
    public RoundDaoDB(JdbcTemplate jdbcTemplate, List current_timeStamp) {
        this.jdbcTemplate = jdbcTemplate;
        Current_TimeStamp = current_timeStamp;
    }



    @Override
    public Round getRoundById(int roundId) {
        try {
            final String SELECT_ROUND_BY_ID = "SELECT * FROM round WHERE round_id = ?";
            return jdbcTemplate.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), roundId);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Round addRound(Round round, Guess guess) {
        final String INSERT_ROUND = "INSERT INTO round(gameId, guess, result, guessTime) VALUES(?,?,?,?)";
        jdbcTemplate.update(INSERT_ROUND, round.getGameId(), round.getGuess(), round.getResult(), round.getGuessTime());

        int newRoundId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setRoundId(newRoundId);
        return getRoundById(newRoundId);
    }


    @Override
    public Object getGuessTime(List getRoundForGame) {
        final String INSERT_ROUND = "SELECT * FROM Round WHERE gameId";
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
    public ResponseEntity<Guess> getAllRoundsByGameId(int gameId) {
        try {
            final String SELECT_ROUNDS_BY_GAMEID = "SELECT * FROM round "
                    + "WHERE gameId = ? ORDER BY guessTime";
            List<Round> rounds = jdbcTemplate.query(SELECT_ROUNDS_BY_GAMEID, new RoundMapper(), gameId);
            return (ResponseEntity<Guess>) rounds;
        } catch(DataAccessException ex) {
            return null;
        }
    }

    @Override
    public Round addRound(Round round) {
        return null;
    }

    @Override
    public int getGameId() {
        return 0;
    }


    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundId(rs.getInt("roundId"));
            round.setResult(rs.getString("result"));
            return round;
        }
    }

}