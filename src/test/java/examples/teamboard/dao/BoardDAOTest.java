package examples.teamboard.dao;

import examples.teamboard.config.DBConfig;
import examples.teamboard.domain.Board;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
public class BoardDAOTest {
    @Autowired
    private DataSource dataSource;
    private BoardDAO boardDAO;

    @Before
    public void init(){
        boardDAO = new BoardDAO(dataSource);
    }

    @Test
    public void testDataSource(){
        Assert.assertNotNull(dataSource);
    }

    @Test
    @Rollback
    public void testInsertBoard(){
        // when
        Board board = new Board();
        board.setTitle("hello");
        board.setContent("helloboard");
        board.setUserId("studyman");
        board.setCategoryNo(1);
        Long boardNo = boardDAO.insertBoard(board);

        // then
        Board board1 = boardDAO.selectBoard(boardNo);
        Assert.assertEquals(board.getTitle(), board1.getTitle());
    }

    @Test
    public void testSelectBoard() throws Exception {
        // given
        Board board = new Board();
        board.setTitle("hello");
        board.setContent("helloboard");
        board.setUserId("studyman");
        board.setCategoryNo(1);
        Long boardNo = boardDAO.insertBoard(board);

        // when
        Board board1 = boardDAO.selectBoard(boardNo);

        // then
        Assert.assertEquals(boardNo, board1.getBoardNo());
    }

    @Test
    public void testSelectBoardList() throws Exception {
        // when
        List<Board> list = boardDAO.selectBoardList(1);

        // then
        //TODO
        // 전체 게시글 가져오는 sql 만들고 그거랑 비교해야함
        Assert.assertEquals(68,list.size());
    }

    @Test
    public void testUpdateBoard() throws Exception {
        // given
        Board board = new Board();
        board.setTitle("title");
        board.setContent("Good morning!");
        board.setUserId("studyman");
        board.setCategoryNo(1);
        long boardNo = boardDAO.insertBoard(board);
        Board board1 = boardDAO.selectBoard(boardNo);

        // when
        board1.setContent("Good afternoon!");
        boardDAO.updateBoard(board1);

        // then
        Board board2 = boardDAO.selectBoard(boardNo);
        Assert.assertEquals(board1.getContent(), board2.getContent());
    }

    @Test
    public void testDeleteBoard() throws Exception {
        // when
        int count = boardDAO.deleteBoard(1L);

        // then
        Board board = boardDAO.selectBoard(1L);
        Assert.assertNull(board);
    }

    @Test
    public void testUpdateBoardHit() throws Exception {
        // given
        Board board = boardDAO.selectBoard(3L);
        Long hitBefore = board.getHit();

        // when
        boardDAO.updateBoardHit(3L);

        // then
        Board board2 = boardDAO.selectBoard(3L);
        Long hitAfter = board2.getHit();
        Assert.assertEquals(hitBefore+1, hitAfter.longValue());
    }
}
