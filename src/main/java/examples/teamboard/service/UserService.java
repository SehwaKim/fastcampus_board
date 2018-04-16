package examples.teamboard.service;

import examples.teamboard.domain.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User longIn(User user);
    public boolean signUp(User user);
    public String findPwd(User user);
    public String findId(User user);
    public boolean checkId(User user);
    public String changePwd(User user);
    public  User getUserInfo(User user);
    public User updateUser(User user);
    public User updateEmail(User user);

}
