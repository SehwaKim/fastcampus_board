package examples.teamboard.dao;

import examples.teamboard.domain.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class FileDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private RowMapper<FileDTO> rowMapper = BeanPropertyRowMapper.newInstance(FileDTO.class);

    @Autowired
    public FileDAO(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("file_attch_info")
                .usingGeneratedKeyColumns("file_no")
                .usingColumns("board_no", "name", "path", "size", "type");
    }

    public Long insertFile(FileDTO fileDTO){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(fileDTO);
        Number fileNo = jdbcInsert.executeAndReturnKey(parameterSource);

        return fileNo.longValue();
    }
}
