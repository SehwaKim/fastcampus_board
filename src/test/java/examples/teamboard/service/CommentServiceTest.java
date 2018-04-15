package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.config.RootApplicationContextConfig;
import examples.teamboard.dao.CommentDAO;
import examples.teamboard.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootApplicationContextConfig.class)
public class CommentServiceTest {
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private CommentDAO commentDAO;
    
    @Test
    public void testInjection() {
        assertNotNull(commentService);
    }
    
    @Test
    public void testGetComments() {
        
        Pagination pagination = new Pagination(0, 5);
    
        List<Comment> comments = commentService.getComments(1, pagination);
        
        assertEquals(pagination.getPostSize(), comments.size());
    }
    
    @Test
    public void testRegistComments() {
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setUserId("freewifi");
        comment.setContent("testContent");
    
        Long commentNo = commentService.registComment(comment);
        comment.setCommentNo(commentNo);
    
        Comment registComment = commentDAO.selectComment(comment);
    
        System.out.println(registComment);
        assertNotNull(registComment);
        assertEquals(0, Long.compare(commentNo, registComment.getCommentGroup()));
        assertEquals(comment.getContent(), registComment.getContent());
        assertEquals(1, registComment.getDepth());
    }
    
    @Test
    public void testRegistReplyComment() {
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setUserId("freewifi");
        comment.setContent("testContent");
        comment.setCommentGroup(5L);
        comment.setDepth(2);
    
        Long commentNo = commentService.registComment(comment);
        comment.setCommentNo(commentNo);
    
        Comment registComment = commentDAO.selectComment(comment);
        assertNotNull(registComment);
        assertNotEquals(commentNo, registComment.getCommentGroup());
        assertEquals(comment.getCommentGroup(), registComment.getCommentGroup());
        assertEquals(2, registComment.getDepth());
    }
    
    @Test
    public void testDeleteComment() {
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setUserId("freewifi");
        comment.setContent("testContent");
        
        Long commentNo = commentService.registComment(comment);
        int deleteCount = commentService.deleteComment(commentNo);
        
        comment.setCommentNo(commentNo);
        Comment deleteComment = commentDAO.selectComment(comment);
        
        assertEquals(1, deleteCount);
        assertNull(deleteComment);
    }
    
    @Test
    public void deleteParentCommentTest() {
        Comment comment = new Comment();
        comment.setBoardNo(2L);
        comment.setUserId("studyman");
        comment.setContent("testContent");
    
        long commentNo = commentService.registComment(comment);
        
        comment.setCommentGroup(commentNo);
        comment.setDepth(2);
        commentService.registComment(comment);
        commentService.registComment(comment);
        commentService.registComment(comment);
    
        int commentGruopCount = commentDAO.commentGruopCount(comment.getCommentGroup());
        assertEquals(4, commentGruopCount);
    
        int affectCount = commentService.deleteComment(commentNo);
        assertTrue(affectCount > 0);
        
        comment.setCommentNo(commentNo);
        Comment deleteComment = commentDAO.selectComment(comment);
        assertEquals(0, deleteComment.getDepth());
    }
}
