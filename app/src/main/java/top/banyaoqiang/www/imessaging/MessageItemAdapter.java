package top.banyaoqiang.www.imessaging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by snx on 18-1-25.
 * ABANDONED! Use MessageAdapter instead.
 */

public class MessageItemAdapter extends ArrayAdapter<MessageItem> {

    private int resourceId;

    public MessageItemAdapter(Context context, int textViewResourceId,
                              List<MessageItem> objects){
        super(context,textViewResourceId,objects);
        this.resourceId = textViewResourceId;
    }

//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//        MessageItem messageItem = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
//
//    }
}
