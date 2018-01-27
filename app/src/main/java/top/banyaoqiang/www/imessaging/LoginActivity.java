package top.banyaoqiang.www.imessaging;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    private final String TAG = "IMDBG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button confirm = findViewById(R.id.btn_confirm);
        Button connect = findViewById(R.id.connect);
        final EditText URL = findViewById(R.id.input_url);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        connect.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                Toast.makeText(LoginActivity.this, "You clicked this", Toast.LENGTH_SHORT).show();
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        Log.d(TAG, "run: "+"going to try");
                        try{
                            Log.d(TAG, "run: trying");
                            OkHttpClient client = new OkHttpClient();
                            Request request = new Request.Builder()
                                    .url("http://39.106.156.178/imsg/data.php")
                                    .build();
                            Log.d(TAG, "run: send request");
                            Response response = client.newCall(request).execute();
                            String data = response.body().string();
                            Log.d(TAG, "run: get response: " + data);
                            Toast.makeText(LoginActivity.this, data, Toast.LENGTH_SHORT).show();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
