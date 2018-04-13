package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.dao.CommentDAO;
import examples.teamboard.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {
    
    @Autowired
    private CommentDAO commentDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Comment> getComments(long boardNo, Pagination pagination) {
        
        return commentDAO.selectList(boardNo, pagination);
    }
    
    @Override
    @Transactional
    public long registComment(Comment comment) {
        Long commentNo = commentDAO.insertComment(comment);
        commentDAO.updateCommentGroup(commentNo);
        return commentNo;
    }
    
    @Override
    @Transactional
    public int deleteComment(long commentNo) {
        
        return commentDAO.deleteComment(commentNo);
    }
}