package examples.teamboard.dao;

import examples.teamboard.config.DBConfig;
import examples.teamboard.domain.User;
import examples.teamboard.util.SecureUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import examples.teamboard.service.UserService;
import examples.teamboard.service.UserServiceImpl;

import javax.sql.DataSource;
import javax.xml.ws.Service;
import java.security.NoSuchAlgorithmException;


@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
@Transactional
public class UserDAOTest {
    @Autowired
    private DataSource dataSource;
    private UserDAO userDAO;

    @Before
    public void setUp() {
        userDAO = new UserDAO(dataSource);
    }
    @Test
    public void testDataSource()
    {
        Assert.assertNotNull(dataSource);
    }
    @Test
    public  void testSelectUser() {
        User user =  userDAO.selectUser("freewifi");
        Assert.assertEquals("freewifi", user.getId());
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        try {
            user.setId("Test4");
            user.setPwd(SecureUtil.sha256Encoding("Test4"));
            user.setEmail("testEmail4@gmail.com");
            user.setName("김김4");
            user.setNickName("김테스트4");
            userDAO.insertUser(user);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        String id = userDAO.selectUserId("김또치","testEmail@gmail.com");
        Assert.assertEquals("TestUser2",id);

    }

    @Test
    public  void testSelectUserID() {
        String userId =  userDAO.selectUserId("박전파","freewifi@naver.com");
        Assert.assertEquals("freewifi", userId);
    }

    @Test
    public  void testSelectUserPwd() {
        String userPwd =  userDAO.selectUserPwd("freewifi","freewifi@naver.com");
        Assert.assertEquals("freewifi", userPwd);
    }
}
