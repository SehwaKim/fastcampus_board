package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.FileDTO;

import java.util.List;
import java.util.Map;

public interface BoardService {
    public List<Board> getBoards(Pagination pagination, int categoryNo, String searchType, String searchStr);
    public Board getBoard(Long boardNo);
    public Map<String, Long> addBoard(Board board, FileDTO fileDTO);
    public int updateBoard(Board board);
    public int deleteBoard(Long boardNo);
    public int getTotalCnt(String searchType, String searchStr);
}