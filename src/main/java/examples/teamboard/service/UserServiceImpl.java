package examples.teamboard.service;

import examples.teamboard.dao.UserDAO;
import examples.teamboard.domain.User;
import examples.teamboard.util.SecureUtil;
import examples.teamboard.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.rmi.CORBA.UtilDelegate;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;
    @Override
    @Transactional(readOnly = true)
    public User login(User user) {
        User dbUser = userDao.selectUser(user.getId());
        if(dbUser != null && (SecureUtil.sha256Encoding(user.getPwd()).equals(dbUser.getPwd())))
            user  = dbUser;
        else{
            user = null;
        }
        return user;
    }

    @Override
    @Transactional
    public int signUp(User user) {
        user.setPwd(SecureUtil.sha256Encoding(user.getPwd()));
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public  User getUserInfo(User user) {
        return userDao.selectUser(user.getId());
    }

    @Override
    @Transactional
    public User updateUser(User user) { //유저정보업데이트
        userDao.updateUser(user);
        return userDao.selectUser(user.getId());
    }

    @Override
    @Transactional
    public User updatePwd(String id, String pwd) { //유저비밀번호업데이트
        userDao.updatePwd(id,SecureUtil.sha256Encoding(pwd));
        return userDao.selectUser(id);
    }

    @Override
    @Transactional
    public String changeTempPwd(User user) { //분실 : 임시비밀번호 발급
        String uuid = UUID.randomUUID().toString();
        uuid= uuid.substring(0,5);
        userDao.updatePwd(user.getId(),SecureUtil.sha256Encoding(uuid));
        return uuid;
    }

    @Override
    @Transactional(readOnly = true)
    public String findId(User user) {
        String id = userDao.selectUserId(user.getName(),user.getEmail());
        return id;
    }

    @Override
    @Transactional(readOnly = true)
    public String findPwd(User user) {
        String pwd = userDao.selectUserPwd(user.getId(),user.getEmail());
        return pwd;
    }

    @Override
    @Transactional(readOnly = true)
    public int checkId(User user) {
        int count = userDao.selectUserCnt(user.getId());
        return count;
    }
}
