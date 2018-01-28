package top.banyaoqiang.www.imessaging;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button login = findViewById(R.id.test_login);
        Button message = findViewById(R.id.test_message);
        Button main = findViewById(R.id.test_main);
        Button web = findViewById(R.id.test_url);
        Button launcher = findViewById(R.id.test_launcher);

        launcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TestActivity.this, LauncherActivity.class);
                startActivity(intent);
            }
        });

        final EditText urlInput = findViewById(R.id.test_url_input);

        web.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TestActivity.this, WebActivity.class);
                String url = urlInput.getText().toString();
                intent.putExtra("http_url",url);
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TestActivity.this, MessageActivity.class);
                intent.putExtra("friend_name","哦哈哈哈哈哈哈哈哈哈哈哈哈额");
                intent.putExtra("friend_id",1103255088);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TestActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        main.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(TestActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
