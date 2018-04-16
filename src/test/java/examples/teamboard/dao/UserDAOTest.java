package examples.teamboard.dao;

import examples.teamboard.config.DBConfig;
import examples.teamboard.domain.User;
import examples.teamboard.util.SecureUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        User user = new User();
        user.setId("selecTest");
        user.setPwd(SecureUtil.sha256Encoding("selecTest"));
        user.setEmail("selecTest@gmail.com");
        user.setName("이셀렉");
        user.setNickname("selecTestNic");
        boolean inUser = userDAO.insertUser(user);

        User user1 = userDAO.selectUser(user.getId());
        Assert.assertEquals(user1.getId(), user.getId());
    }

    @Test
    public  void testSelectUserCnt() {
        User user = new User();
        user.setId("selecTestCnt");
        user.setPwd(SecureUtil.sha256Encoding("selecTestCnt"));
        user.setEmail("selecTestCnt@gmail.com");
        user.setName("김카운트");
        user.setNickname("selecTestCntNic");
        boolean inUser = userDAO.insertUser(user);

        int cnt = userDAO.selectUserCnt(user.getId());
        Assert.assertEquals(1, cnt);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setId("InsertTest");
        user.setPwd(SecureUtil.sha256Encoding("InsertTest"));
        user.setEmail("InsertTest@gmail.com");
        user.setName("김인설");
        user.setNickname("InsertTestNic");
        userDAO.insertUser(user);

        String compId = userDAO.selectUserId(user.getName(),user.getEmail());
        Assert.assertEquals(user.getId(),compId);

    }

    @Test
    public  void testSelectUserID() {
        User user = new User();
        user.setId("SelecIDTest");
        user.setPwd(SecureUtil.sha256Encoding("SelecIDTest"));
        user.setEmail("SelecIDTest@gmail.com");
        user.setName("김아이디");
        user.setNickname("SelecIDTestNic");
        userDAO.insertUser(user);

        String userId =  userDAO.selectUserId(user.getName(),user.getEmail());
        Assert.assertEquals(user.getId(), userId);
    }

    @Test
    public  void testSelectUserPwd() throws NoSuchAlgorithmException {

        User user = new User();
        user.setId("SelecPwdTest");
        user.setPwd(SecureUtil.sha256Encoding("SelecPwdTest"));
        user.setEmail("SelecPwdTest@gmail.com");
        user.setName("김패스");
        user.setNickname("SelecPwdTestNic");
        userDAO.insertUser(user);

        String userPwd =  userDAO.selectUserPwd(user.getId(),user.getEmail());

        Assert.assertEquals(user.getPwd(), userPwd);
    }

    @Test
    public  void testUpdatePwd() {
        User user = new User();
        user.setId("selecTest");
        user.setPwd(SecureUtil.sha256Encoding("selecTest"));
        user.setEmail("selecTest@gmail.com");
        user.setName("이업뎃");
        user.setNickname("selecTestNic");
        boolean inUser = userDAO.insertUser(user);

        user.setPwd(SecureUtil.sha256Encoding("updateTest"));
        userDAO.updatePwd(user);
        Assert.assertEquals(user.getPwd(),SecureUtil.sha256Encoding("updateTest"));
    }

    @Test
    public  void testUpdateUser() {
        User user = new User();
        user.setId("selecTest");
        user.setPwd(SecureUtil.sha256Encoding("selecTest"));
        user.setEmail("selecTest@gmail.com");
        user.setName("이업뎃");
        user.setNickname("selecTestNic");
        boolean inUser = userDAO.insertUser(user);

        user.setEmail("updateTest@naver.com");
        user.setPwd(SecureUtil.sha256Encoding("updateTest"));
        userDAO.updateUser(user);
        Assert.assertEquals(user.getEmail(),"updateTest@naver.com");
    }

    @Test
    public  void testUpdateEmail() {
        User user = new User();
        user.setId("selecTest");
        user.setPwd(SecureUtil.sha256Encoding("selecTest"));
        user.setEmail("selecTest@gmail.com");
        user.setName("이이멜");
        user.setNickname("selecTestNic");
        boolean inUser = userDAO.insertUser(user);

        user.setEmail("updateTest@naver.com");
        userDAO.updateEmail(user);
        Assert.assertEquals(user.getEmail(),"updateTest@naver.com");
    }
}
