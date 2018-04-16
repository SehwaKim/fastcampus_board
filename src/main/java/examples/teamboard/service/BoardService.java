package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    public List<Board> getBoards(Pagination pagination, int categoryNo, String searchType, String searchStr);
    public Board getBoard(Long boardNo);
    public Long addBoard(Board board, MultipartFile file);
    public int updateBoard(Board board);
    public int deleteBoard(Long boardNo);
    public int getTotalCnt(String searchType, String searchStr);
    public FileInfo getFileInfo(Long fileNo);
}