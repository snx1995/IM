package top.banyaoqiang.www.imessaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Message> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMessage();
        RecyclerView recyclerView = findViewById(R.id.main_message_list);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        MessageAdapter adapter = new MessageAdapter(messageList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    public void initMessage(){
        String[] data = {"hello","你好～","你是？","很高兴见到你","我也是","拜拜","再见","哈哈","呵呵"};
        String[] userNames = {"Tom","小明","小红","Tony","小刚","斯皮尔伯格","泰山","骗子","傻子"};
        for(int i=0;i<data.length;i++){
            HistoryMessage hm = new HistoryMessage(data[i],R.drawable.receive_tmp,userNames[i],12131,2);
            messageList.add(hm);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.main_menu_add_friend:
                break;
            case R.id.main_menu_my_info:
                break;
            case R.id.main_menu_logout:
                break;
            case R.id.main_menu_exit:
                finish();
                break;
        }
        return true;
    }
}
