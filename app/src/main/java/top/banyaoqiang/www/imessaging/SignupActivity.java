package top.banyaoqiang.www.imessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        WebView webview = (WebView)findViewById(R.id.sign_web);
        webview.setHorizontalScrollBarEnabled(false);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://39.106.156.178/codeview/index.php");
    }
}
