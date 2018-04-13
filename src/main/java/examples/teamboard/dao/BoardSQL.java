package examples.teamboard.dao;

public final class BoardSQL {
   public static String getTotalCnt(String searchType){
        StringBuilder sb = new StringBuilder("select count(*) as totalCnt from board\n");
        if(searchType != null){
            if(!isCorrectSearchType(searchType)) {
                throw new IllegalArgumentException("Incorrect SearchType :: " + searchType);
            }
            sb.append("where board.").append(searchType).append(" like concat('%', :searchStr, '%')");
        }
        return sb.toString();
    }

    /**
     * 검색용 쿼리 생성
     * @param searchType
     * @return
     */
    public static String createSelectListSQL(String searchType) {
        StringBuilder sb = new StringBuilder();
        sb.append("select board.board_no\n");
        sb.append(", title\n");
        sb.append(", hit\n");
        sb.append(", board.user_id\n");
        sb.append(", nickname\n");
        sb.append(", category_no\n");
        sb.append(", udate\n");
        sb.append(", count(comment.comment_no) as comment_cnt\n");
        sb.append("from board LEFT OUTER JOIN comment\n");
        sb.append("on board.board_no = comment.board_no\n");
        sb.append("LEFT OUTER JOIN user_info u ON board.user_id = u.id\n");
        sb.append("where category_no = :categoryNo\n");
        if(searchType != null) {
            if(!isCorrectSearchType(searchType)) {
                throw new IllegalArgumentException("Incorrect SearchType :: " + searchType);
            }
            sb.append("and board.").append(searchType).append(" like CONCAT('%', :searchStr, '%')\n");
        }
        sb.append("GROUP BY board.board_no\n");
        sb.append("order by desc\n");
        sb.append("limit :startIdx, :postSize");
        
        return sb.toString();
    }
    
    private static boolean isCorrectSearchType(String searchType) {
        boolean correct = false;
        
        if("title".equalsIgnoreCase(searchType)) {
            correct = true;
        }
        else if("content".equalsIgnoreCase(searchType)) {
            correct = true;
        }
        
        return correct;
    }
    
    public static final String selectBoard = "select board_no" +
            "      , title" +
            "      , content" +
            "      , hit" +
            "      , board.user_id" +
            "      , category_no" +
            "      , udate" +
            " from board" +
            " where board_no = :boardNo";

    public static final String updateBoard =
            "update board set" +
                    "  title = :title" +
                    "  , content = :content" +
                    "  , udate = CURRENT_TIMESTAMP" +
                    " where board_no = :boardNo";

    public static final String deleteBoard = "DELETE from board where board_no = :boardNo";

    public static final String updateBoardHit = "update board set hit = hit+1 where board_no = :boardNo";

    private BoardSQL(){}
}
