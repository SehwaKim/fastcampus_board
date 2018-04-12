package examples.teamboard.dao;

public final class UserSQL {
    public static final  String selectUser =
            "select id" +
            "      , pwd" +
            "from user_info" +
            "WHERE id = :id";
    public static final String insertUser=
            "INSERT INTO user_info (" +
            "  id" +
            "  , pwd" +
            "  , email" +
            "  , nickname" +
            "  , name" +
            ") VALUES (:id, :pwd, :email, :nickname, :name)";
    public static final String selectUserId= 
            "select id" + 
                    "from user_info" +
                    "where email = :email and name = :name";
    public static final String selectUserPwd =
            "select pwd" +
            "from user_info" +
            "WHERE id = :id and email = :email";
    private UserSQL() { }
}
