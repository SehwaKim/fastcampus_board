package examples.teamboard.domain;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private long userNo;
    private String id;
    private String pwd;
    private String email;
    private String nickname;
    private String name;
}
