package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.dao.BoardDAO;
import examples.teamboard.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDAO boardDAO;

    @Override
    @Transactional
    public List<Board> getBoards(Pagination pagination, int categoryNo) {
        //TODO
        // Pagination 객체를 이용해서 페이징 처리를 해야함
        // 현재는 category_no로 카테고리별 모든 게시물 가져오고 있음
        // 검색의 경우도 구현해야 함

        List<Board> list = boardDAO.selectBoardList(categoryNo);
        return list;
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
    public Long addBoard(Board board) {
        Long boardNo = boardDAO.insertBoard(board);
        return boardNo;
    }

    @Override
    @Transactional
    public int updateBoard(Board board) {
        int count = boardDAO.updateBoard(board);
        return count;
    }

    @Override
    @Transactional
    public int deleteBoard(Long boardNo) {
        //글이 삭제되면 딸린 댓글도 모두 삭제 되어야 한다. 한 트랜젝션인가?
        int count = boardDAO.deleteBoard(boardNo);
        return count;
    }
}
