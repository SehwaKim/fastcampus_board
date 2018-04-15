package examples.teamboard.dao;

import examples.teamboard.common.Pagination;
import examples.teamboard.config.DBConfig;
import examples.teamboard.domain.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DBConfig.class)
public class CommentDAOTest {
    
    @Autowired
    private DataSource dataSource;
    private CommentDAO commentDAO;
    
    @Before
    public void init() {
        this.commentDAO = new CommentDAO(dataSource);
    }
    
    @Test
    public void testDataSource() {
        assertNotNull(dataSource);
    }
    
    @Test
    public void testSelectCommentList() {
        int postSize = 10;
        Pagination pagination = new Pagination(0, postSize);
        
        List<Comment> commentList = commentDAO.selectList(1L, pagination);
        assertNotEquals(0, commentList.size());
        assertEquals(postSize, commentList.size());
    }
    
    @Test
    public void testTotalCommentCount() {
        long totalCommentCount = commentDAO.totalCommentCount(1L);
        assertNotEquals(0, totalCommentCount);
    }
    
    @Test
    public void testSelectComment() {
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setCommentNo(1L);
        Comment selectedComment = commentDAO.selectComment(comment);
        assertNotNull(selectedComment);
    }
    
    
    @Test
    public void testInsertComment() {
        
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setContent("comment content");
        comment.setUserId("studyman");
        
        long beforeCommentCount = commentDAO.totalCommentCount(comment.getBoardNo());
        long commentNo = commentDAO.insertComment(comment);
        long afterCommentCount = commentDAO.totalCommentCount(comment.getBoardNo());
        
        System.out.println(commentNo);
        
        assertNotEquals(0, commentNo);
        assertNotEquals(beforeCommentCount, afterCommentCount);
        assertEquals(beforeCommentCount + 1L, afterCommentCount);
    }
    
    @Test
    public void testRegistComment() {
        
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setContent("comment content");
        comment.setUserId("studyman");
        
        Long commentNo = commentDAO.insertComment(comment);
        
        commentDAO.updateCommentGroup(commentNo, commentNo, comment.getDepth());
    
        comment.setCommentNo(commentNo);
        Comment registedComment = commentDAO.selectComment(comment);
        
        assertEquals(1, registedComment.getDepth());
        assertEquals(comment.getContent(), registedComment.getContent());
        assertEquals(0, Long.compare(commentNo, registedComment.getCommentGroup()));
    }
    
    @Test
    public void testDeleteComment() {
        
        // given
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setUserId("studyman");
        comment.setContent("testContent");
        Long commentNo = commentDAO.insertComment(comment);
        long beforeCount = commentDAO.totalCommentCount(comment.getBoardNo());
        
        // when
        int deleteCount = commentDAO.deleteComment(commentNo);
        long afterCount = commentDAO.totalCommentCount(comment.getBoardNo());
        
        // then
        assertEquals(1, deleteCount);
        assertEquals(beforeCount - 1, afterCount);
    }
    
    @Test
    public void testDeleteParentComment() {
        Comment comment = new Comment();
        comment.setBoardNo(2L);
        comment.setUserId("studyman");
        comment.setContent("testContent");
        Long commentNo = commentDAO.insertComment(comment);
        
        assertTrue(commentNo > 0);
    
        commentDAO.deleteParentComment(commentNo);
        
        comment.setCommentNo(commentNo);
        Comment deleteComment = commentDAO.selectComment(comment);
        
        assertEquals(0, deleteComment.getDepth());
    }
    
    @Test
    public void testCommentGroupCount() {
        Comment comment = new Comment();
        comment.setBoardNo(2L);
        comment.setUserId("studyman");
        comment.setContent("testContent");
    
        long commentNo = commentDAO.insertComment(comment);
        comment.setCommentGroup(commentNo);
        commentDAO.updateCommentGroup(commentNo, comment.getCommentGroup(), 1);
        
        commentNo = commentDAO.insertComment(comment);
        commentDAO.updateCommentGroup(commentNo, comment.getCommentGroup(), 2);
        commentNo = commentDAO.insertComment(comment);
        commentDAO.updateCommentGroup(commentNo, comment.getCommentGroup(), 2);
        commentNo = commentDAO.insertComment(comment);
        commentDAO.updateCommentGroup(commentNo, comment.getCommentGroup(), 2);
    
        int commentGruopCount = commentDAO.commentGruopCount(comment.getCommentGroup());
        assertEquals(4, commentGruopCount);
    }
    
}

