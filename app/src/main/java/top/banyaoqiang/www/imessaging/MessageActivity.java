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
                    Message msg = new Message(12231,text,"Tom",R.drawable.receive_tmp,R.drawable.send_tmp,Message.MESSAGE_SEND);
                    messageList.add(msg);
                    adapter.notifyItemInserted(messageList.size()-1);
                    messagesView.scrollToPosition(messageList.size()-1);
                    message.setText("");
                }
            }
        });
    }

    private void initMessageList(){
        Message msg1 = new Message(12231,"hello","Tom",R.drawable.receive_tmp,R.drawable.send_tmp,Message.MESSAGE_RECEIVE);
        Message msg2 = new Message(3211,"who's this?","Jerry",R.drawable.receive_tmp,R.drawable.send_tmp,Message.MESSAGE_SEND);
        Message msg3 = new Message(12231,"hello,hh, 阿斯达所啊注册记录卡数量单价垃圾群文件而　奥斯卡的骄傲就是的奋斗的风格水电费","Tom",R.drawable.receive_tmp,R.drawable.send_tmp,Message.MESSAGE_RECEIVE);
        Message msg4 = new Message(12231,"hello,hh, 怕不是个事还是电话走线槽号和期望空间哈斯卡活动卡萨丁很快就走线槽你爸妈说的","Tom",R.drawable.receive_tmp,R.drawable.send_tmp,Message.MESSAGE_SEND);
        //Message msg5 = new Message(12231,"hello,hh, lalaalallalalalalalalalalalalalalalalalalalala","Tom",R.drawable.receive_tmp,R.drawable.send_tmp,Message.MESSAGE_HISTORY);
        messageList.add(msg1);
        messageList.add(msg2);
        messageList.add(msg3);
        messageList.add(msg4);
        //messageList.add(msg5);
    }
}
