package top.banyaoqiang.www.imessaging;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by snx on 18-1-26.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<MessageItem> messageList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView userPhoto;
        TextView friendName;
        TextView friendText;

        public ViewHolder(View view){
            super(view);
            userPhoto = view.findViewById(R.id.message_item_photo);
            userPhoto.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            friendName = view.findViewById(R.id.message_item_friend_name);
            friendText = view.findViewById(R.id.message_item_friend_text);
        }
    }

    public MessageAdapter(List<MessageItem> msgs){
        messageList = msgs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessageItem message = messageList.get(position);
        holder.userPhoto.setImageResource(message.getUserPhotoId());
        holder.friendName.setText(message.getUserName());
        holder.friendText.setText(message.getMessage());
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
