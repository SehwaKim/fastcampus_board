package examples.teamboard.service;

import examples.teamboard.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User longIn(User user);
    public int signUp(User user);
    public String findPwd(User user);
    public String findId(User user);
    public boolean checkId(User user);
    public String changeTempPwd(User user);
    public  User getUserInfo(User user);
    public User updateUser(User user);
    public User updatePwd(String id, String pwd);
}
