package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.config.DBConfig;
import examples.teamboard.config.RootApplicationContextConfig;
import examples.teamboard.dao.BoardDAO;
import examples.teamboard.domain.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void testGetBoards(){
        // given
        String searchType = "content";
        String searchStr = "입니다";
        int totalCnt = boardService.getTotalCnt(searchType, searchStr);
        int postSize = 10;
        Pagination pagination = new Pagination(totalCnt, postSize);

        // when
        List<Board> list = boardService.getBoards(pagination, 1, searchType, searchStr);

        // then
        Assert.assertTrue(list.size() == totalCnt || list.size() <= 10);
        //이거 근데 어떻게 적절하게 assert해야 할 지 모르겠어요
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBoardsByIllgalArgument(){
        // given
        String searchType = "illegalSearchType";
        String searchStr = "입니다";
        int totalCnt = boardService.getTotalCnt(searchType, searchStr);
        int postSize = 10;
        Pagination pagination = new Pagination(totalCnt, postSize);

        // when
        List<Board> list = boardService.getBoards(pagination, 1, searchType, searchStr);
    }

    @Test
    public void testGetBoard(){
        // given
        Board board = new Board();
        board.setTitle("hello");
        board.setContent("helloboard");
        board.setUserId("sehwa");
        board.setCategoryNo(1);
        Long boardNo = boardService.addBoard(board);

        // when
        Board board1 = boardService.getBoard(boardNo);

        // then
        Assert.assertEquals(boardNo, board1.getBoardNo());
    }

    @Test
    public void testAddBoard(){
        // when
        Board board = new Board();
        board.setTitle("hello");
        board.setContent("helloboard");
        board.setUserId("sehwa");
        board.setCategoryNo(1);
        Long boardNo = boardService.addBoard(board);

        // then
        Board board1 = boardService.getBoard(boardNo);
        Assert.assertEquals(boardNo, board1.getBoardNo());
        Assert.assertEquals(board.getContent(), board1.getContent());
    }

    @Test
    public void testUpdateBoard(){
        // given
        Board board = new Board();
        board.setTitle("hello");
        board.setContent("helloboard");
        board.setUserId("sehwa");
        board.setCategoryNo(1);
        Long boardNo = boardService.addBoard(board);

        // when
        board.setBoardNo(boardNo);
        board.setContent("goodbye board");
        boardService.updateBoard(board);

        // then
        Board board1 = boardService.getBoard(boardNo);
        Assert.assertEquals(board.getContent(), board1.getContent());
    }

    @Test
    public void testDeleteBoard(){
        // given
        Board board = new Board();
        board.setTitle("hello");
        board.setContent("helloboard");
        board.setUserId("sehwa");
        board.setCategoryNo(1);
        Long boardNo = boardService.addBoard(board);

        // when
        boardService.deleteBoard(boardNo);

        // then
        Assert.assertNull(boardService.getBoard(boardNo));
    }

    @Test
    public void testGetTotalCnt(){
        // given
        String searchType = "title";
        String searchStr = "안녕";

        // when
        try{
            boardService.getTotalCnt(searchType, searchStr);
        }catch (Exception e){
            Assert.fail("exception이 나면 안되는 경우임");
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTotalCntByIllegalArgument(){
        // given
        String searchType = "illegalSearchType";
        String searchStr = "안녕";

        // when
        boardService.getTotalCnt(searchType, searchStr);
    }
}
