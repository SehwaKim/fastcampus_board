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
import java.util.*;

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
    public Map<String,String> selectUser(String id)
    {
        Map<String,String> result = new HashMap<>();
        User user= null;
        Map<String,String> map=Collections.singletonMap("id",id);
        try{
            user= template.queryForObject(UserSQL.selectUser, map,rowMapper);

        } catch (DataAccessException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        result.put("id",user.getId());
        result.put("pwd",user.getPwd());
        return result;
    }
    public Long insertUser(User user)
    {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        Number userNo = insert.executeAndReturnKey(parameterSource);
        return userNo.longValue();
    }

    public String selectUserId(String name,String email)
    {
        String userId = null;
       // SqlParameterSource parameterSource= new BeanPropertySqlParameterSource(user);
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        try
        {
            userId = template.queryForObject(UserSQL.selectUserId,map,String.class);
        }catch (IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return userId;
    }
    public String selectUserPwd(String id, String email)
    {
        String userPwd = null;
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("email",email);
        try
        {
            userPwd = template.queryForObject(UserSQL.selectUserPwd,map,String.class);
        }catch (IncorrectResultSizeDataAccessException e){
            e.printStackTrace();
        }catch (DataAccessException e){
            e.printStackTrace();
        }
        return userPwd;
    }

}
