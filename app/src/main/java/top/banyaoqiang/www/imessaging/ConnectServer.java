package top.banyaoqiang.www.imessaging;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by snx on 18-1-16.
 */

public class ConnectServer {
    public static void sendMessage(String message){
        Log.d("IMDBG", "sendMessage: "+message);
    }

    public static boolean connect(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().build();
        try{
            Response response = client.newCall(request).execute();
            String data = response.body().string();

        }catch(IOException e){
            e.printStackTrace();
        }


        return true;
    }
}
