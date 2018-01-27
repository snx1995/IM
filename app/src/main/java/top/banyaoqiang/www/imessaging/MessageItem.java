package top.banyaoqiang.www.imessaging;

/**
 * Created by snx on 18-1-25.
 */

public class MessageItem {
    private String message;
    private String userId;
    private String userName;
    private String userPhoto;
    private int userPhotoId;

    public MessageItem(String message,String userId,String userName,String userPhoto,int userPhotoId){
        this.message = message;
        this.userId = userId;
        this.userName = userName;
        this.userPhoto = userPhoto;
        this.userPhotoId = userPhotoId;
    }

    public String getMessage() {
        return message;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public int getUserPhotoId(){
        return userPhotoId;
    }
}