package examples.teamboard.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Long commentNo;
    private Long boardNo;
    private String content;
    private String userId;
    private Date regdate;
    private int depth;
    private Long commentGroup = 0L;
    private String nickname;
}
