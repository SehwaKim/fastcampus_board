package examples.teamboard.domain;

import lombok.Data;

import java.util.Date;

@Data
public class FileDTO {
    private Long fileNo;
    private Long boardNo;
    private String name;
    private String path;
    private int size;
    private String type;
    private Date regdate;
}
