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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        pagination.setStartIdx(0);
    
        List<Comment> comments = commentService.getComments(1, pagination);
        
        assertEquals(pagination.getPostSize(), comments.size());
    }
    
    @Test
    public void testRegistComments() {
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setUser_id("freewifi");
        comment.setContent("testContent");
    
        Long commentNo = commentService.registComment(comment);
        comment.setCommentNo(commentNo);
    
        Comment registComment = commentDAO.selectComment(comment);
    
        System.out.println(registComment);
        assertNotNull(registComment);
        assertEquals(0, Long.compare(commentNo, registComment.getComment_group()));
        assertEquals(comment.getContent(), registComment.getContent());
    }
    
    @Test
    public void testDeleteComment() {
        Comment comment = new Comment();
        comment.setBoardNo(1L);
        comment.setUser_id("freewifi");
        comment.setContent("testContent");
        
        Long commentNo = commentService.registComment(comment);
        int deleteCount = commentService.deleteComment(commentNo);
        
        comment.setCommentNo(commentNo);
        Comment deleteComment = commentDAO.selectComment(comment);
        
        assertEquals(1, deleteCount);
        assertNull(deleteComment);
    }
    
}
