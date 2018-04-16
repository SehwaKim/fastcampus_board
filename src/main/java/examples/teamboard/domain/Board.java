package examples.teamboard.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Board {
    private Long boardNo;
    private String title;
    private String content;
    private Long hit;
    private Date regdate;
    private String userId;
    private String nickname;
    private int categoryNo;
    private Date udate;
    private int commentCnt;
    private List<Long> fileNoList;
}