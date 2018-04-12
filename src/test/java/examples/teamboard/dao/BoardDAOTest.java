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
        Board board = new Board();

        board.setTitle("title");
        board.setContent("content");
        board.setUserId("studyman");
        board.setCategoryNo(1);
        long boardNo = boardDAO.insertBoard(board);
        Assert.assertEquals(69, boardNo);
    }

    @Test
    public void testSelectBoard(){
        Board board = boardDAO.selectBoard(1L);
        Assert.assertEquals("studyman",board.getUserId());
    }
}
