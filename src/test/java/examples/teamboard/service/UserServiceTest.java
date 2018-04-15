package examples.teamboard.service;

import examples.teamboard.config.RootApplicationContextConfig;
import examples.teamboard.domain.User;
import examples.teamboard.service.UserService;
import examples.teamboard.util.SecureUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
        user.setId("LoginTest");
        user.setPwd(SecureUtil.sha256Encoding("LoginTest"));
        user.setEmail("LoginTest@gmail.com");
        user.setName("김로그");
        user.setNickname("LoginTestNic");
        userService.signUp(user);

        User user1 =  userService.longIn(user);
        Assert.assertEquals(user1.getPwd(),user.getPwd());
    }

    @Test
    public void testSingUp() {
        User user = new User();
        user.setId("singUpTest");
        user.setPwd(SecureUtil.sha256Encoding("singUpTest"));
        user.setEmail("singUpTest@gmail.com");
        user.setName("김가입");
        user.setNickname("singUpTestNic");

        boolean sing = userService.signUp(user);
        User user1 = userService.longIn(user);

        Assert.assertEquals(user1.getPwd(),user.getPwd());
    }

    @Test
    public  void testFindId() {
        User user = new User();
        user.setId("FindId");
        user.setPwd(SecureUtil.sha256Encoding("FindId"));
        user.setEmail("FindId@gmail.com");
        user.setName("김아이디");
        user.setNickname("FindIdNic");
        boolean sing = userService.signUp(user);

        String userId =  userService.findId(user);

        Assert.assertEquals(user.getId(), userId);
    }

    @Test
    public  void testFindPwd() {
        User user = new User();
        user.setId("FindPwd");
        user.setPwd(SecureUtil.sha256Encoding("FindPwd"));
        user.setEmail("FindPwd@gmail.com");
        user.setName("김패스");
        user.setNickname("FindPwdNic");
        boolean sing = userService.signUp(user);

        String userPwd = userService.findPwd(user);
        Assert.assertEquals(user.getPwd(), userPwd);
    }

    @Test
    public  void testCheckId() {
        User user = new User();
        user.setId("CheckId");
        user.setPwd(SecureUtil.sha256Encoding("CheckId"));
        user.setEmail("CheckId@gmail.com");
        user.setName("김체크");
        user.setNickname("CheckIdNic");
        boolean singup = userService.signUp(user);

        boolean result =  userService.checkId(user);
        Assert.assertTrue(result);
    }
    @Test
    public void testChangPwd()
    {
        User user = new User();
        user.setId("CheckId");
        user.setPwd(SecureUtil.sha256Encoding("CheckId"));
        user.setEmail("CheckId@gmail.com");
        user.setName("김체크");
        user.setNickname("CheckIdNic");
        boolean singup = userService.signUp(user);

        String uuid = userService.changePwd(user);
        String pwd = userService.findPwd(user);
        Assert.assertEquals(SecureUtil.sha256Encoding(uuid),pwd);


    }
}
