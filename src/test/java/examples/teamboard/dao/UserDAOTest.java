package examples.teamboard.dao;

import examples.teamboard.config.DBConfig;
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
        User user = new User();
        user.setId("sehwa");
        User resultUser =  userDAO.selectUser(user);
        Assert.assertEquals("1235", resultUser.getPwd());
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
        User user = new User();
        user.setName("박전파");
        user.setEmail("freewifi@naver.com");
        String userId =  userDAO.selectUserId(user);
        Assert.assertEquals("freewifi", userId);
    }

    @Test
    public  void testSelectUserPwd()
    {
        User user = new User();
        user.setId("freewifi");
        user.setEmail("freewifi@naver.com");
        String userPwd =  userDAO.selectUserPwd(user);
        Assert.assertEquals("freewifi", userPwd);
    }




}
