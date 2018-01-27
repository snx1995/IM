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

    private final String TAG = "IMDBG";
    private String[] friendNames = {"Tom","Jerry","John","jack","Michael","Maria","Linda","Tony"};
    private String[] data = {"Hello","Who's this?","I'm Tom","Oh, hello Tom","Hello Jerry",
        "I want to visit your home","No,never!","Please~"};
    private List<MessageItem> messageList = new ArrayList<>();
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
        RecyclerView recycler = findViewById(R.id.message_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);
        MessageAdapter adapter = new MessageAdapter(messageList);
        recycler.setAdapter(adapter);


        Button send = findViewById(R.id.message_send);
        final EditText message = findViewById(R.id.message_input_text);

        send.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MessageActivity.this, message.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initMessageList(){
        for(int i=0;i<friendNames.length;i++){
            MessageItem item = new MessageItem(data[i],"aaa", friendNames[i],"test",R.drawable.receive_tmp);
            messageList.add(item);
        }
    }
}
