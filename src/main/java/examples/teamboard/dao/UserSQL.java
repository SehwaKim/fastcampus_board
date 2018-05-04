package examples.teamboard.dao;

public final class UserSQL {
    public static final  String selectUser =
            "SELECT id, pwd, name, nickname, email FROM user_info WHERE id=:id";
    public static final String insertUser=
            "INSERT INTO user_info (id, pwd, email, nickname, name) VALUES (:id, :pwd, :email, :nickname, :name)";
    public static final String selectUserId =
            "SELECT id FROM user_info WHERE email=:email and name=:name";
    public static final String selectUserPwd =
            "SELECT pwd FROM user_info WHERE id =:id and email=:email";
    public static final String selectUserCnt=
            "SELECT COUNT(*) FROM user_info WHERE id=:id";
    public static final String updatePwd =
            "UPDATE user_info SET pwd=:pwd WHERE id=:id";
    public static final String updateUser =
            "UPDATE user_info SET email=:email,nickname=:nickname WHERE id=:id";
    public static final String deleteUser =
            "DELETE FROM user_info WHERE id=:id";
    private UserSQL() { }
}
