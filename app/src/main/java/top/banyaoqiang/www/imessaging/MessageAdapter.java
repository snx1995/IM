package top.banyaoqiang.www.imessaging;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by snx on 18-1-27.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    private final String TAG = "IMDBG";
    private List<Message> messageList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout sendLayout;
        LinearLayout receiveLayout;
        LinearLayout historyLayout;

        public ViewHolder(View view){
            super(view);
            sendLayout = view.findViewById(R.id.message_send_layout);
            receiveLayout  = view.findViewById(R.id.message_receive_layout);
            historyLayout = view.findViewById(R.id.message_history_layout);
        }
    }

    public MessageAdapter(List<Message> messageList){
        this.messageList = messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bubble_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = messageList.get(position);
        setMessage(holder,message);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    private void setMessage(ViewHolder holder, Message message){
        switch (message.getMessageType()){
            case Message.MESSAGE_SEND:
                holder.receiveLayout.setVisibility(View.GONE);
                holder.historyLayout.setVisibility(View.GONE);
                LinearLayout send = holder.sendLayout;
                send.setVisibility(View.VISIBLE);
                ((TextView)send.findViewById(R.id.message_send_text)).setText(message.getText());
                ((ImageView)send.findViewById(R.id.message_send_user_image)).setImageResource(message.getUserImage());
                break;
            case Message.MESSAGE_RECEIVE:
                holder.sendLayout.setVisibility(View.GONE);
                holder.historyLayout.setVisibility(View.GONE);
                LinearLayout receive = holder.receiveLayout;
                receive.setVisibility(View.VISIBLE);
                ((TextView)receive.findViewById(R.id.message_receive_text)).setText(message.getText());
                ((ImageView)receive.findViewById(R.id.message_receive_user_image)).setImageResource(message.getUserImage());
                break;
            case Message.MESSAGE_HISTORY:
                holder.sendLayout.setVisibility(View.GONE);
                holder.receiveLayout.setVisibility(View.GONE);
                LinearLayout history = holder.historyLayout;
                history.setVisibility(View.VISIBLE);
                message = (HistoryMessage) message;
                ((TextView)history.findViewById(R.id.message_item_friend_text)).setText(message.getText());
                ((TextView)history.findViewById(R.id.message_item_friend_name)).setText(((HistoryMessage) message).getUserName());
                ((ImageView)history.findViewById(R.id.message_item_photo)).setImageResource(message.getUserImage());
                break;
            default:
                Log.d(TAG, "setMessage: wrong message type");
        }
    }
}
