package top.banyaoqiang.www.imessaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by snx on 18-1-30.
 */

public class AddressBookAdapter extends RecyclerView.Adapter<AddressBookAdapter.ViewHolder> {
    private List<Friend> friendList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView friendImage;
        TextView friendName;

        public ViewHolder(View view){
            super(view);
            friendImage = view.findViewById(R.id.address_friend_image);
            friendName = view.findViewById(R.id.address_friend_name);
        }
    }

    public AddressBookAdapter(List<Friend> friendList){
        this.friendList = friendList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Friend friend = friendList.get(position);
        holder.friendImage.setImageResource(friend.getImage());
        holder.friendName.setText(friend.getName());

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        final ViewGroup vg = parent;
        holder.friendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Friend friend = friendList.get(position);
                Intent intent = new Intent(vg.getContext(),InfoDetailActivity.class);
                intent.putExtra("user_name",friend.getName());
                intent.putExtra("user_image",friend.getImage());
                intent.putExtra("user_id",friend.getId());
                vg.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
