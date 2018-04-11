package examples.teamboard.dao;

import examples.teamboard.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BoardDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private RowMapper<Board> rowMapper = BeanPropertyRowMapper.newInstance(Board.class);

    @Autowired
    public BoardDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("board").usingGeneratedKeyColumns("board_no");
    }

    public Long insertBoard(Board board){
        SqlParameterSource sqlparameter = new BeanPropertySqlParameterSource(board);
        Number boardNo = jdbcInsert.executeAndReturnKey(sqlparameter);

        return boardNo.longValue();
    }

    public List<Board> selectBoardList(){
        return null;
    }

}