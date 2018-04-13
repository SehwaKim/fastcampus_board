package examples.teamboard.service;

import examples.teamboard.domain.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public boolean longIn(User user);
    public boolean singUp(User user);
    public String findPwd(User user);
    public String findId(User user);



}
