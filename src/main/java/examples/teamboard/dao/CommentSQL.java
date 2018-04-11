package examples.teamboard.dao;

public final class CommentSQL {
    public static final String selectList = "select comment_no" +
            "    , user_id" +
            "    , content" +
            "    , regdate" +
            "    , depth" +
            "from comment" +
            "where board_no = :board_no" +
            "order by comment_group, comment_no";
            //"LIMIT 0, 10";

    public static final String updateCommentGroup = "UPDATE comment set comment_group = comment_no where comment_no = :commentNo";

    public static final String deleteComment = "DELETE from comment where comment_no = :commentNo";

    private CommentSQL(){}
}
