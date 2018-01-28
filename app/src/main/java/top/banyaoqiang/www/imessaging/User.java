package top.banyaoqiang.www.imessaging;

/**
 * Created by snx on 18-1-28.
 */

public class User {
    private int userId;
    private String userName;
    private int userImage;

    public User(int userId, String userName, int userImage) {
        this.userId = userId;
        this.userName = userName;
        this.userImage = userImage;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserImage() {
        return userImage;
    }
}
