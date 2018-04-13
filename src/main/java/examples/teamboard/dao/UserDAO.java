package examples.teamboard.dao;

import examples.teamboard.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
    public User selectUser(String id)
    {
        User user= null;
        Map<String,String> map=Collections.singletonMap("id",id);
        try{
            user= template.queryForObject(UserSQL.selectUser, map,rowMapper);

        } catch (DataAccessException e){
            throw e;
        }
        return user;
    }
    public void insertUser(User user)
    {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        try {
            insert.execute(parameterSource);
        } catch (DataAccessException e) {
            throw e;
        }
    }

    public String selectUserId(String name,String email)
    {
        String userId = null;
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        try {
            userId = template.queryForObject(UserSQL.selectUserId,map,String.class);
        }catch (DataAccessException e){
            throw  e;
        }
        return userId;
    }
    public String selectUserPwd(String id, String email)
    {
        String userPwd = null;
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("email",email);
        try {
            userPwd = template.queryForObject(UserSQL.selectUserPwd,map,String.class);
        }catch (DataAccessException e){
            throw e;
        }
        return userPwd;
    }

}
