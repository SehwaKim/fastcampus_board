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
    public void testLogin() {
        User user = new User();
        user.setId("LoginTest");
        user.setPwd(SecureUtil.sha256Encoding("LoginTest"));
        user.setEmail("LoginTest@gmail.com");
        user.setName("김로그");
        user.setNickname("LoginTestNic");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        user.setPwd("LoginTest");
        User user1 = userService.login(user);
        Assert.assertEquals(user1.getPwd(),SecureUtil.sha256Encoding("LoginTest"));
    }

    @Test
    public void testGetUserInfo() {
        User user = new User();
        user.setId("LoginTest");
        user.setPwd(SecureUtil.sha256Encoding("LoginTest"));
        user.setEmail("LoginTest@gmail.com");
        user.setName("김로그");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        User user1 = userService.getUserInfo(user);
        Assert.assertEquals(user1.getPwd(), user.getPwd());
    }

    @Test
    public void testSingUp() {
        User user = new User();
        user.setId("singUpTest");
        user.setPwd("singUpTest");
        user.setEmail("singUpTest@gmail.com");
        user.setName("김가입");
        user.setNickname("singUpTestNic");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        user.setPwd("singUpTest");
        User user1 = userService.login(user);
        Assert.assertEquals(user1.getPwd(),SecureUtil.sha256Encoding("singUpTest"));
    }

    @Test
    public void testFindId() {
        User user = new User();
        user.setId("FindId");
        user.setPwd(SecureUtil.sha256Encoding("FindId"));
        user.setEmail("FindId@gmail.com");
        user.setName("김아이디");
        user.setNickname("FindIdNic");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        String userId = userService.findId(user);
        Assert.assertEquals(user.getId(), userId);
    }

    @Test
    public void testFindPwd() {
        User user = new User();
        user.setId("FindPwd");
        user.setPwd(SecureUtil.sha256Encoding("FindPwd"));
        user.setEmail("FindPwd@gmail.com");
        user.setName("김패스");
        user.setNickname("FindPwdNic");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        String userPwd = userService.findPwd(user);
        Assert.assertEquals(user.getPwd(), userPwd);
    }

    @Test
    public void testCheckId() {
        User user = new User();
        user.setId("CheckId");
        user.setPwd(SecureUtil.sha256Encoding("CheckId"));
        user.setEmail("CheckId@gmail.com");
        user.setName("김체크");
        user.setNickname("CheckIdNic");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        int result = userService.checkId(user);
        Assert.assertEquals(1,result);
    }

    @Test
    public void testchangeTempPwd () {
        User user = new User();
        user.setId("CheckId");
        user.setPwd(SecureUtil.sha256Encoding("CheckId"));
        user.setEmail("CheckId@gmail.com");
        user.setName("김체크");
        user.setNickname("CheckIdNic");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        String uuid = userService.changeTempPwd(user);
        String pwd = userService.findPwd(user);
        Assert.assertEquals(SecureUtil.sha256Encoding(uuid), pwd);
    }

    @Test
    public void testupdateUser () {
        User user = new User();
        user.setId("CheckId");
        user.setEmail("CheckId@gmail.com");
        user.setName("김체크");
        user.setNickname("CheckIdNic");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        user.setEmail("update@gmail.com");
        user.setNickname("update");
        userService.updateUser(user);

        Assert.assertEquals(user.getEmail(),"update@gmail.com");
        Assert.assertEquals(user.getNickname(),"update");
    }
    @Test
    public void testupdatePwd()
    {
        User user = new User();
        user.setId("CheckPwd");
        user.setPwd(SecureUtil.sha256Encoding("CheckPwd"));
        user.setEmail("CheckPwd@gmail.com");
        user.setName("김비번");
        user.setNickname("ChangePwd");
        int signUp = userService.signUp(user);
        Assert.assertEquals(1,signUp);

        userService.updatePwd(user.getId(),"change");
        Assert.assertEquals(user.getPwd(),SecureUtil.sha256Encoding("change"));
    }

}
