package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.dao.BoardDAO;
import examples.teamboard.dao.FileDAO;
import examples.teamboard.domain.Board;
import examples.teamboard.domain.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {
    private BoardDAO boardDAO;
    private FileDAO fileDAO;

    public BoardServiceImpl(BoardDAO boardDAO, FileDAO fileDAO) {
        this.boardDAO = boardDAO;
        this.fileDAO = fileDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> getBoards(Pagination pagination, int categoryNo, String searchType, String searchStr) {
        return boardDAO.selectBoardList(pagination, categoryNo, searchType, searchStr);
    }

    @Override
    @Transactional
    public Board getBoard(Long boardNo) {
        //TODO
        // hit이 증가하되 세션이 유지되는 한 동일 사용자로 인한 hit의 중복 증가를 막아야 함
        // 게시물을 읽는 동시에 댓글도 가져와야 하는데 comment list를 가져오는 것도 이 트랙젝션에 포함일까?

        Board board = boardDAO.selectBoard(boardNo);
        boardDAO.updateBoardHit(boardNo);

        return board;
    }

    @Override
    @Transactional
    public Map<String, Long> addBoard(Board board, FileDTO fileDTO) {
        Long boardNo = boardDAO.insertBoard(board);
        fileDTO.setBoardNo(boardNo);
        Long fileNo = fileDAO.insertFile(fileDTO);
        Map<String, Long> map = new HashMap<>();
        map.put("boardNo", boardNo);
        map.put("fileNo", fileNo);
        return map;
    }

    @Override
    @Transactional
    public int updateBoard(Board board) {
        return boardDAO.updateBoard(board);
    }

    @Override
    @Transactional
    public int deleteBoard(Long boardNo) {
        return boardDAO.deleteBoard(boardNo);
    }

    @Override
    @Transactional(readOnly = true)
    public int getTotalCnt(String searchType, String searchStr){
        return boardDAO.selectTotalCnt(searchType, searchStr);
    }
}
