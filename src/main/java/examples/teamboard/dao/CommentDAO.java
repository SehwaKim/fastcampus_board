package examples.teamboard.dao;

import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import java.util.List;
import java.util.Map;

@Repository
public class CommentDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);

    @Autowired
    public CommentDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("comment")
                .usingGeneratedKeyColumns("comment_no")
                .usingColumns("board_no", "content", "user_id");
        
    }

    public Long insertComment(Comment comment){
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(comment);
        Number commentNo = jdbcInsert.executeAndReturnKey(namedParameters);

        return commentNo.longValue();
    }

    public int updateCommentGroup(Long commentNo){
        String sql = CommentSQL.updateCommentGroup;
        Map<String, Long> map = Collections.singletonMap("commentNo", commentNo);
        int count = jdbcTemplate.update(sql, map);

        return count;
    }

    public List<Comment> selectList(Long boardNo, Pagination pagination) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("boardNo", boardNo)
                .addValue("postSize", pagination.getPostSize())
                .addValue("startIdx", pagination.getStartIdx());
    
        return jdbcTemplate.query(CommentSQL.selectList, parameterSource, rowMapper);
    }

    public int deleteComment(Long commentNo){
        String sql = CommentSQL.deleteComment;
        Map<String, Long> map = Collections.singletonMap("commentNo", commentNo);
        int count = jdbcTemplate.update(sql, map);

        return count;
    }
    
    public int totalCommentCount(Long boardNo) {
        try {
            return jdbcTemplate.queryForObject(CommentSQL.totalCommentCount, Collections.singletonMap("boardNo", boardNo), Integer.class);
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return 0;
        }
        
    }
    
    public Comment selectComment(Comment comment) {
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(comment);
        try {
            return jdbcTemplate.queryForObject(CommentSQL.selectComment, sqlParameterSource, rowMapper);
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

}
