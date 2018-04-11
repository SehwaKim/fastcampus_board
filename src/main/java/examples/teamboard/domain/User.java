package examples.teamboard.domain;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Long userNo;
    private String id;
    private String pwd;
    private String email;
    private String nickName;
    private String name;
    private Date regdate;
}
