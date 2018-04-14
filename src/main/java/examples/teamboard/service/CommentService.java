package examples.teamboard.service;

import examples.teamboard.common.Pagination;
import examples.teamboard.domain.Comment;

import java.util.List;

public interface CommentService {

    public List<Comment> getComments(long boardNo, Pagination pagination);
    
    public long registComment(Comment comment);
    
    public int deleteComment(long commentNo);

    public int totalCount(long boardNo);
    
}
