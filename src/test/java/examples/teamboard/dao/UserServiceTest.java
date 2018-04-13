package examples.teamboard.dao;

import examples.teamboard.config.DBConfig;
import examples.teamboard.config.RootApplicationContextConfig;
import examples.teamboard.domain.User;
import examples.teamboard.service.UserService;
import examples.teamboard.util.SecureUtil;
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
import java.security.NoSuchAlgorithmException;


@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
@Transactional
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public  void testLogin() {
        User user = new User();
        user.setId("TestUser");
        user.setPwd("TestUse");
        boolean result =  userService.longIn(user);

        Assert.assertEquals(false, result);
    }

    @Test
    public void testSingUp() {
        User user = new User();
        user.setId("Test3");
        user.setPwd("1234");
        user.setEmail("testEmail3@gmail.com");
        user.setName("김태스트3");
        user.setNickName("Test3"); //중복된 값
        boolean result = userService.singUp(user);

        Assert.assertEquals(false,result);
    }

    @Test
    public  void testFindId() {
        User user = new User();
        user.setName("박전");
        user.setEmail("freewifi@naver.com");
        String userId =  userService.findId(user);

        Assert.assertEquals(null, userId);
    }

    @Test
    public  void testFindPwd() {
        User user = new User();
        user.setId("freewifi");
        user.setEmail("freewifi@naver.com");
        String userPwd =  userService.findPwd(user);

        try {
            Assert.assertEquals(SecureUtil.sha256Encoding("freewifi"), userPwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
