package examples.teamboard.dao;

import examples.teamboard.domain.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class CategoryDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert jdbcInsert;
    private RowMapper<Category> rowMapper;

    public CategoryDAO(DataSource dataSource){
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("category").usingColumns("name");
        this.rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
    }

    public int insertCategory(String name){
        Map map = Collections.singletonMap("name", name);
        return jdbcInsert.execute(map);
    }

    public int updateName(Category category){
        return jdbcTemplate.update(CategorySQL.updateName, new BeanPropertySqlParameterSource(category));
    }

    public List<Category> selectCategoryList(){
        return jdbcTemplate.query(CategorySQL.selectCategories, rowMapper);
    }

    public int deleteCategory(int categoryNo){
        Map map = Collections.singletonMap("categoryNo", categoryNo);
        return jdbcTemplate.update(CategorySQL.deleteCategory, map);
    }
}
