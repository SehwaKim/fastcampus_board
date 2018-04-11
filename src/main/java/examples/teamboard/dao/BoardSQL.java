package examples.teamboard.dao;

public final class BoardSQL {
    public static final String selectList =
            "select board.board_no" +
                    "      , title" +
                    "      , hit" +
                    "      , board.user_id" +
                    "      , category_no" +
                    "      , udate" +
                    "      , count(comment.comment_no) as comment_cnt" +
                    "from board LEFT OUTER JOIN comment" +
                    "    on board.board_no = comment.board_no" +
                    "where category_no = :categoryNo" +
                    "  GROUP BY board.board_no";
    //"LIMIT 0, 10";

    public static final String selectBoard = "select board_no" +
            "      , title" +
            "      , content" +
            "      , hit" +
            "      , board.user_id" +
            "      , category_no" +
            "      , udate" +
            "from board" +
            "where board_no = :boardNo";

    public static final String updateBoard =
            "update board set" +
                    "  title = :title" +
                    "  , content = :content" +
                    "  , udate = CURRENT_TIMESTAMP" +
                    "where board_no = :boardNo";

    public static final String deleteBoard = "DELETE from board where board_no = :boardNo";

    private BoardSQL(){}
}
