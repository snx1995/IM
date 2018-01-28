package top.banyaoqiang.www.imessaging;

/**
 * Created by snx on 18-1-27.
 */

public class Message {
    public static final int MESSAGE_SEND = 0;
    public static final int MESSAGE_RECEIVE = 1;
    public static final int MESSAGE_HISTORY = 2;

    private String text;
    private int userImage;
    private int messageType;

    public Message(){
        this.messageType = 3;
    }

    public Message(String text, int userImage,int messageType){
        this.messageType = messageType;
        this.text = text;
        this.userImage = userImage;
    }

    public String getText() {
        return text;
    }

    public int getUserImage() {
        return userImage;
    }

    public int getMessageType() {
        return messageType;
    }
}

class SentMessage extends Message{

    public SentMessage(String text,int userImage){
        super(text,userImage,Message.MESSAGE_SEND);
    }
}

class ReceivedMessage extends Message{

    public ReceivedMessage(String text, int userImage){
        super(text,userImage,Message.MESSAGE_RECEIVE);
    }
}

class HistoryMessage extends Message{
    private String userName;
    private int userId;
    private int count;

    public HistoryMessage(String text, int userImage,String userName, int userId, int count) {
        super(text, userImage, Message.MESSAGE_HISTORY);
        this.userName = userName;
        this.userId = userId;
        this.count = count;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    public int getCount() {
        return count;
    }
}