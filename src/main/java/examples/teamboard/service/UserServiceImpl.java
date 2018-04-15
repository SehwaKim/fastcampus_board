package examples.teamboard.service;

import examples.teamboard.dao.UserDAO;
import examples.teamboard.domain.User;
import examples.teamboard.util.SecureUtil;
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
    public User longIn(User user) {
        User dbUser = userDao.selectUser(user.getId());
        if(dbUser != null && (user.getPwd().equals(dbUser.getPwd())))
            user  = dbUser;
        else{
            user = null;
        }
        return user;
    }

    @Override
    @Transactional
    public boolean signUp(User user) {
        boolean result = userDao.insertUser(user);
        System.out.println("service return : " + result);
        return  result;
    }

    @Override
    @Transactional(readOnly = true)
    public String findPwd(User user) {
        String pwd = userDao.selectUserPwd(user.getId(),user.getEmail());
        return pwd;
    }

    @Override
    public String updateUser(User user) {
        //TODO
        //유저정보 수정
        return null;
    }

    @Override
    @Transactional
    public String changePwd(User user) {
        String uuid = UUID.randomUUID().toString();
        uuid= uuid.substring(0,5);
        user.setPwd(SecureUtil.sha256Encoding(uuid));
        userDao.updatePwd(user);
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
    public boolean checkId(User user) {
        boolean result = false;
        int cnt = userDao.selectUserCnt(user.getId());
        if(cnt == 1)
            result = true;
        return result;
    }
}
