package examples.teamboard.dao;

public final class FileSQL {
    public static final String selectFile =
            "select file_no" +
                    ", board_no" +
                    ", name" +
                    ", path" +
                    ", size" +
                    ", type" +
                    ", regdate" +
                    " from file_attch_info where file_no=:fileNo";

    public static final String selectFileNo = "select file_no from file_attch_info where board_no = :boardNo";

    private FileSQL(){}
}
