package examples.teamboard.dao;

import examples.teamboard.domain.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FileDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private RowMapper<FileInfo> rowMapper = BeanPropertyRowMapper.newInstance(FileInfo.class);

    @Autowired
    public FileDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("file_attch_info")
                .usingGeneratedKeyColumns("file_no")
                .usingColumns("board_no", "name", "path", "size", "type");
    }

    public Long insertFile(FileInfo fileDTO){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(fileDTO);
        Number fileNo = jdbcInsert.executeAndReturnKey(parameterSource);

        return fileNo.longValue();
    }

    public FileInfo selectFile(Long fileNo){
        Map<String, Long> map = Collections.singletonMap("fileNo", fileNo);
        SqlParameterSource parameterSource = new MapSqlParameterSource(map);

        return jdbcTemplate.queryForObject(FileSQL.selectFile, parameterSource, rowMapper);
    }

    public List<Long> selectFileNo(Long boardNo){
        Map<String, Long> map = Collections.singletonMap("boardNo", boardNo);
        SqlParameterSource parameterSource = new MapSqlParameterSource(map);

        return jdbcTemplate.queryForList(FileSQL.selectFileNo, parameterSource, Long.class);
    }
}
