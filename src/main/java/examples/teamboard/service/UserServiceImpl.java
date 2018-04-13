package examples.teamboard.service;

import examples.teamboard.dao.UserDAO;
import examples.teamboard.domain.User;
import examples.teamboard.util.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;

    @Override
    @Transactional(readOnly = true)
    public boolean longIn(User user) {

        User dbUser = userDao.selectUser(user.getId());
        boolean result = false;
        try {
            if(dbUser.getId() != null && (SecureUtil.sha256Encoding(user.getPwd()).equals(dbUser.getPwd())))
                result = true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    @Transactional
    public boolean singUp(User user) {
        boolean result = true;
        try {
           userDao.insertUser(user);

        }catch (DataAccessException e)
        {
            result = false;
        }
        return  result;
    }

    @Override
    @Transactional(readOnly = true)
    public String findPwd(User user) {
        String pwd = null;
        try {
            pwd = userDao.selectUserPwd(user.getId(),user.getEmail());

        }catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return pwd;
    }

    @Override
    @Transactional(readOnly = true)
    public String findId(User user) {
        String id = null;
        try {
            id = userDao.selectUserId(user.getName(),user.getEmail());

        }catch (DataAccessException e)
        {
            e.printStackTrace();
        }
        return id;
    }
}
