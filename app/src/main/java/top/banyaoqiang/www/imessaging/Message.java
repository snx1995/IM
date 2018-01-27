package top.banyaoqiang.www.imessaging;

/**
 * Created by snx on 18-1-27.
 */

public class Message {
    public static final int MESSAGE_SEND = 0;
    public static final int MESSAGE_RECEIVE = 1;
    public static final int MESSAGE_HISTORY = 2;

    private int friendId;
    private String text;
    private String friendName;
    private int friendImage;
    private int messageType;
    private int myImage;

    public Message(int friendId, String text, String friendName, int friendImage, int myImage, int messageType){
        this.friendId =friendId;
        this.text = text;
        this.friendName = friendName;
        this.friendImage = friendImage;
        this.messageType = messageType;
        this.myImage = myImage;
    }

    public int getFriendId() {
        return friendId;
    }

    public String getText() {
        return text;
    }

    public String getFriendName() {
        return friendName;
    }

    public int getFriendImage() {
        return friendImage;
    }

    public int getMessageType() {
        return messageType;
    }

    public int getMyImage() {
        return myImage;
    }
}