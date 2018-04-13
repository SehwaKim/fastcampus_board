package examples.teamboard.service;

import examples.teamboard.dao.UserDAO;
import examples.teamboard.domain.User;
import examples.teamboard.util.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;

    @Override
    @Transactional(readOnly = true)
    public boolean longIn(User user) {
        boolean result;
        User dbUser = userDao.selectUser(user.getId());
        if(dbUser != null && (user.getPwd().equals(dbUser.getPwd())))
            result  = true;
        else
            result = false;

        return result;
    }

    @Override
    @Transactional
    public boolean singUp(User user) {
        boolean result = userDao.insertUser(user);
        return  result;
    }

    @Override
    @Transactional(readOnly = true)
    public String findPwd(User user) {
        String pwd = userDao.selectUserPwd(user.getId(),user.getEmail());
        return pwd;
    }

    @Override
    @Transactional(readOnly = true)
    public String findId(User user) {
        String id = userDao.selectUserId(user.getName(),user.getEmail());
        return id;
    }
}
