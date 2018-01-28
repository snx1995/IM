package top.banyaoqiang.www.imessaging;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private static final String TAG = "IMDBG";
    private RecyclerView messagesView;
    private MessageAdapter adapter;
    private List<Message> messageList = new ArrayList<>();

    private String friendName;
    private long friendId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        TopBar topBar = findViewById(R.id.message_top_bar);
        topBar.setTitle("Tom");
        topBar.setMenuButtonOnclickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MessageActivity.this, "You click message's menu button", Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent = getIntent();
        this.friendName = intent.getStringExtra("friend_name");
        this.friendId = intent.getIntExtra("friend_id",-1);

        topBar.setTitle(friendName);

        initMessageList();
        messagesView = findViewById(R.id.message_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        messagesView.setLayoutManager(layoutManager);
        adapter = new MessageAdapter(messageList);
        messagesView.setAdapter(adapter);

        Button send = findViewById(R.id.message_send);
        final EditText message = findViewById(R.id.message_input_text);


        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text = message.getText().toString();
                if(!"".equals(text)){
                    SentMessage sm = new SentMessage(text, R.drawable.send_tmp);
                    messageList.add(sm);
                    adapter.notifyItemInserted(messageList.size()-1);
                    messagesView.scrollToPosition(messageList.size()-1);
                    message.setText("");
                }
            }
        });
    }

    private void initMessageList(){
        String[] data = {"hello","你好～","你是？","很高兴见到你","我也是","拜拜","再见","哈哈","呵呵"};
        for(int i=0;i<data.length;i++){
            if(i%2==0){
                ReceivedMessage rm = new ReceivedMessage(data[i],R.drawable.receive_tmp);
                messageList.add(rm);
            }
            else{
                SentMessage sm = new SentMessage(data[i],R.drawable.send_tmp);
                messageList.add(sm);
            }
        }
    }
}
