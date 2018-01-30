package top.banyaoqiang.www.imessaging;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class AddressBookActivity extends AppCompatActivity {

    private List<Friend> friendList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_book);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        TopBar topBar = findViewById(R.id.address_top_bar);
        topBar.setTitle("通讯录");

        initFriendList();

        LinearLayoutManager manager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.address_recycler);
        AddressBookAdapter adpter = new AddressBookAdapter(friendList);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adpter);

    }

    private void initFriendList(){
        String[] names = {"Tom","Jerry","渣渣","谁啊","Tony","Maria","Linda","Michael","Jane","Lucy"};
        for(String name:names){
            Friend friend = new Friend(1,name,R.drawable.receive_tmp);
            friendList.add(friend);
        }
    }
}