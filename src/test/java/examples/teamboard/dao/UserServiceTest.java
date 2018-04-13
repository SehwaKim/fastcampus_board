package examples.teamboard.dao;

import examples.teamboard.config.RootApplicationContextConfig;
import examples.teamboard.domain.User;
import examples.teamboard.service.UserService;
import examples.teamboard.util.SecureUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private UserDAO userDAO;

    @Test
    public  void testLogin() {
        User user = new User();
        user.setId("LoginTest");
        user.setPwd(SecureUtil.sha256Encoding("LoginTest"));
        user.setEmail("LoginTest@gmail.com");
        user.setName("김로그");
        user.setNickName("LoginTestNic");
        userService.singUp(user);

        boolean result =  userService.longIn(user);
        Assert.assertTrue(result);
    }

    @Test
    public void testSingUp() {
        User user = new User();
        user.setId("singUpTest");
        user.setPwd(SecureUtil.sha256Encoding("singUpTest"));
        user.setEmail("singUpTest@gmail.com");
        user.setName("김가입");
        user.setNickName("singUpTestNic");

        boolean sing = userService.singUp(user);
        boolean lonin = userService.longIn(user);

        Assert.assertEquals(sing,lonin);
    }

    @Test
    public  void testFindId() {
        User user = new User();
        user.setId("FindId");
        user.setPwd(SecureUtil.sha256Encoding("FindId"));
        user.setEmail("FindId@gmail.com");
        user.setName("김아이디");
        user.setNickName("FindIdNic");
        boolean sing = userService.singUp(user);

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
        user.setNickName("FindPwdNic");
        boolean sing = userService.singUp(user);

        String userPwd =  userService.findPwd(user);

        Assert.assertEquals(user.getPwd(), userPwd);
    }
}
