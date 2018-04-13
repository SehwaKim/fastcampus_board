package examples.teamboard.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Long commentNo;
    private Long boardNo;
    private String content;
    private String user_id;
    private Date regdate;
    private int depth;
    private Long comment_group;
    private String nickname;
}
