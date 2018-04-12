package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Board;

import java.util.List;

public interface BoardService {
    public List<Board> getBoards(Pagination pagination, int categoryNo);
    public Board getBoard(Long boardNo);
    public int addBoard(Board board);
    public int updateBoard(Board board);
    public int deleteBoard(Long boardNo);
}