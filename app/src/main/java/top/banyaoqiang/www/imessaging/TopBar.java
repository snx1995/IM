package top.banyaoqiang.www.imessaging;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by snx on 18-1-25.
 */

public class TopBar extends LinearLayout {

    private Button back;
    private Button menu;
    private TextView title;

    public TopBar(Context context, AttributeSet attrs){
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.top_bar,this);

        this.back = findViewById(R.id.back);
        this.menu = findViewById(R.id.menu);
        this.title = findViewById(R.id.top_bar_title);

        this.back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                ((Activity) getContext()).finish();
            }
        });
    }

    public void setMenuButtonOnclickListener(OnClickListener l){
        this.menu.setOnClickListener(l);
    }

    public void setBackButtonOnClickListener(OnClickListener l){
        this.back.setOnClickListener(l);
    }

    public void setTitle(String t){
        if(t.length()>12) t=t.substring(0,10)+"..";
        this.title.setText(t);
    }

    public void setBackText(String text){
        this.back.setText(text);
    }

    public void setMenuText(String text){
        this.menu.setText(text);
    }
}
