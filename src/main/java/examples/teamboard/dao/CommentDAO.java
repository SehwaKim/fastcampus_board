package examples.teamboard.dao;

import examples.teamboard.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CommentDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);

    @Autowired
    public CommentDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("comment").usingGeneratedKeyColumns("comment_no");
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

    public int registComment(Comment comment){
        Long commentNo = insertComment(comment);
        int count = updateCommentGroup(commentNo);

        return count;
    }

    public List<Comment> selectList(Long boardNo){
        String sql = CommentSQL.selectList;
        Map<String, Long> map = Collections.singletonMap("boardNo", boardNo);
        List<Comment> list = jdbcTemplate.query(sql, map, rowMapper);

        //TODO
        // 페이징처리 해야 함

        return list;
    }

    public int deleteComment(Long commentNo){
        String sql = CommentSQL.deleteComment;
        Map<String, Long> map = Collections.singletonMap("commentNo", commentNo);
        int count = jdbcTemplate.update(sql, map);

        return count;
    }

}
