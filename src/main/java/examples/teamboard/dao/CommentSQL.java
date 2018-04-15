package examples.teamboard.dao;

public final class CommentSQL {
    
    public static final String selectList = "select comment_no" +
            "    , user_id\n" +
            "    , content\n" +
            "    , comment.regdate\n" +
            "    , nickname\n"+
            "    , depth\n" +
            " from comment left outer join user_info\n" +
            " on comment.user_id = user_info.id\n" +
            " where board_no = :boardNo\n" +
            " order by comment_group, comment_no\n"+
            " limit :startIdx, :postSize";
        
    public static final String updateCommentGroup = "UPDATE comment set comment_group = :commentGroup where comment_no = :commentNo";
    
    public static String createUpdateCommentGroupSQL(int depth) {
        StringBuilder builder = new StringBuilder();
        
        builder.append("UPDATE comment\n");
        builder.append("set comment_group = :commentGroup\n");
        if(depth > 0) {
            builder.append(", depth = :depth\n");
        }
        builder.append("where comment_no = :commentNo\n");
        
        return builder.toString();
    }
    
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
