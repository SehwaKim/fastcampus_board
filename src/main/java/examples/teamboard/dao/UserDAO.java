package examples.teamboard.dao;

import examples.teamboard.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Map;

@Repository
public class UserDAO {
    private NamedParameterJdbcTemplate template;
    private SimpleJdbcInsert insert;
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    @Autowired
    public UserDAO(DataSource dataSource) {
        template = new NamedParameterJdbcTemplate(dataSource);
        insert = new SimpleJdbcInsert(dataSource).withTableName("user_info").usingGeneratedKeyColumns("user_no");

    }
    public User selectUser(User user)
    {
        User returnUser = null;
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        try{
            returnUser = template.queryForObject(UserSQL.selectUser, parameterSource,rowMapper);

        } catch (DataAccessException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return returnUser;
    }
    public Long insertUser(User user)
    {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        Number userNo = insert.executeAndReturnKey(parameterSource);
        return userNo.longValue();
    }

    public String selectUserId(User user)
    {
        String userId = null;
        SqlParameterSource parameterSource= new BeanPropertySqlParameterSource(user);
        try
        {
            userId = template.queryForObject(UserSQL.selectUserId,parameterSource,String.class);
        }catch (IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return userId;
    }
    public String selectUserPwd(User user)
    {
        String userPwd = null;
        SqlParameterSource parameterSource= new BeanPropertySqlParameterSource(user);
        try
        {
            userPwd = template.queryForObject(UserSQL.selectUserPwd,parameterSource,String.class);
        }catch (IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return userPwd;
    }

}
