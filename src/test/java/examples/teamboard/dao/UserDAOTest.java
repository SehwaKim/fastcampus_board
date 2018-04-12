package examples.teamboard.dao;

import examples.teamboard.config.DBConfig;
import examples.teamboard.dao.UserDAO;
import examples.teamboard.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@Transactional
public class UserDAOTest {
    @Autowired
    private DataSource dataSource;
    private UserDAO userDAO;

    @Before
    public void setUp()
    {
        userDAO = new UserDAO(dataSource);
    }
    @Test
    public void testDataSource()
    {
        Assert.assertNotNull(dataSource);
    }
    @Test
    public  void testSelectUser()
    {
        Map<String,String> map =  userDAO.selectUser("noriming2");
        Assert.assertEquals("noriming2", map.get("id"));
        //TODO
        //암호화 해야됨..
    }

    @Test
    public void testInsertUser()
    {
        User user = new User();
        user.setId("testId");
        user.setPwd("1234");
        user.setEmail("testEmail@gmail.com");
        user.setName("김또치");
        user.setNickName("또치또치");
       long result = userDAO.insertUser(user);
        Assert.assertEquals(9,result);
    }

    @Test
    public  void testSelectUserID()
    {
        String userId =  userDAO.selectUserId("박전파","freewifi@naver.com");
        Assert.assertEquals("freewifi", userId);
    }

    @Test
    public  void testSelectUserPwd()
    {
        String userPwd =  userDAO.selectUserPwd("freewifi","freewifi@naver.com");
        Assert.assertEquals("freewifi", userPwd);
    }




}
