package examples.teamboard.dao;

public final class CommentSQL {
    public static final String selectList = "select comment_no" +
            "    , user_id\n" +
            "    , content\n" +
            "    , regdate\n" +
            "    , depth\n" +
            " from comment\n" +
            " where board_no = :boardNo\n" +
            " order by comment_group, comment_no";
            //"LIMIT 0, 10";

    public static final String updateCommentGroup = "UPDATE comment set comment_group = comment_no where comment_no = :commentNo";

    public static final String deleteComment = "DELETE from comment where comment_no = :commentNo";
    
    public static final String totalCommentCount = "select count(*) as commentCount\n" +
            "from comment\n" +
            "where board_no = :boardNo";
    
    public static final String selectComment = "select comment_no\n" +
            "  , board_no\n" +
            "  , content\n" +
            "  , user_id\n" +
            "  , regdate\n" +
            "  , depth\n" +
            "  , comment_group\n" +
            "from comment\n" +
            "where board_no = :boardNo\n" +
            "  and comment_no = :commentNo\n";
    
    private CommentSQL(){}
}
