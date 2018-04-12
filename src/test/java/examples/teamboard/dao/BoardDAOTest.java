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
        board.setTitle("title");
        board.setContent("content");
        board.setUserId("studyman");
        board.setCategoryNo(1);
        long boardNo = boardDAO.insertBoard(board);

        // then
        Assert.assertEquals(69, boardNo);
    }

    @Test
    public void testSelectBoard() throws Exception {
        // when
        Board board = boardDAO.selectBoard(1L);

        // then
        Assert.assertEquals("studyman",board.getUserId());
    }

    @Test
    public void testSelectBoardList() throws Exception {
        // when
        List<Board> list = boardDAO.selectBoardList();

        // then
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
        int count = boardDAO.updateBoard(board1);

        // then
        Board board2 = boardDAO.selectBoard(boardNo);
        Assert.assertEquals(1, count);
    }

    @Test
    public void testDeleteBoard() throws Exception {
        // when
        int count = boardDAO.deleteBoard(1L);

        // then
        Board board = boardDAO.selectBoard(1L);
        Assert.assertNull(board);
    }
}
