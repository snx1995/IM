package top.banyaoqiang.www.imessaging;

/**
 * Created by snx on 18-1-30.
 */

public class Friend {
    private int id;
    private String name;
    private int image;

    public Friend(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
