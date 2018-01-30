package top.banyaoqiang.www.imessaging;

import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_detail);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();

        TopBar topBar = findViewById(R.id.detail_top_bar);
        topBar.setTitle("详细信息");

        Button send = findViewById(R.id.detail_send_message);
        Intent intent = getIntent();
        final int userId = intent.getIntExtra("user_id",-1);
        final String userName = intent.getStringExtra("user_name");
        final int userImage = intent.getIntExtra("user_image",-1);

        TextView name = findViewById(R.id.detail_user_name);
        ImageView image = findViewById(R.id.detail_user_image);
        TextView id = findViewById(R.id.detail_user_id);
        name.setText(userName);
        image.setImageResource(userImage);
        id.setText(userId+"");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(InfoDetailActivity.this, MessageActivity.class);
                intent1.putExtra("user_id",userId);
                intent1.putExtra("user_name",userName);
                intent1.putExtra("user_image",userImage);
                startActivity(intent1);
            }
        });
    }
    private void getUserInfo(Intent intent){
        /***
         * 获取用户资料，在此处访问服务端
         * 设置用户信息
         */
    }
}
