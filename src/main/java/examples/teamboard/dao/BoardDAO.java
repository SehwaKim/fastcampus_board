package examples.teamboard.dao;

import examples.teamboard.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String sql = BoardSQL.selectList;

        List<Board> boardList = jdbcTemplate.query(sql, rowMapper);

        return boardList;
    }

    public Board selectBoard(Long boardNo){
        String sql = BoardSQL.selectBoard;
        Map<String, Long> map = Collections.singletonMap("boardNo", boardNo);

        try {
            Board board = jdbcTemplate.queryForObject(sql, map, rowMapper);

            return board;

        }catch (IncorrectResultSizeDataAccessException ex){
            ex.printStackTrace();

            return null;
        }
    }

    public int updateBoard(Board board){
        String sql = BoardSQL.updateBoard;
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(board);
        int count = jdbcTemplate.update(sql, namedParameters);

        return count;
    }

    public int deleteBoard(Long boardNo){
        String sql = BoardSQL.deleteBoard;
        Map<String, Long> map = Collections.singletonMap("boardNo", boardNo);
        int count = jdbcTemplate.update(sql, map);

        return count;
    }
}