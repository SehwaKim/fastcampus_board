package examples.teamboard.dao;

import examples.teamboard.domain.User;
import examples.teamboard.service.UserService;
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
        User user;
        Map<String,String> map=Collections.singletonMap("id",id);
        user= template.queryForObject(UserSQL.selectUser, map,rowMapper);

        return user;
    }
    public int selectUserCnt(String id)
    {
        Map<String,String> map=Collections.singletonMap("id",id);
        int count= template.queryForObject(UserSQL.selectUserCnt, map,Integer.class);

        return count;

    }
    public int insertUser(User user)
    {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);
        int count =  insert.execute(parameterSource);
        return count;
    }
    public String selectUserId(String name,String email)
    {
        String userId;
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("email",email);
        userId = template.queryForObject(UserSQL.selectUserId,map,String.class);

        return userId;
    }
    public String selectUserPwd(String id, String email)
    {
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("email",email);
        String userpwd = template.queryForObject(UserSQL.selectUserPwd,map,String.class);

        return userpwd;
    }

    public int updatePwd(String id, String pwd)
    {
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("pwd",pwd);
       int count = template.update(UserSQL.updatePwd,map);

       return count;
    }

    public  int updateUser(User user)
    {
        SqlParameterSource param = new BeanPropertySqlParameterSource(user);
        int count = template.update(UserSQL.updateUser,param);

        return count;
    }

    public int deleteUser(String id)
    {
        Map<String,String> map=Collections.singletonMap("id",id);
        int count =  template.queryForObject(UserSQL.deleteUser, map,Integer.class);

        return count;
    }
}
