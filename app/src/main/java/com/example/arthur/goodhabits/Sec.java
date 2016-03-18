package com.example.arthur.goodhabits;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class Sec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        Toolbar toolbar = (Toolbar) findViewById(R.id.sec_toolbar);
        setSupportActionBar(toolbar);

        String data="";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            data = extras.getString("data");
        }


        ScrollView sv = (ScrollView)findViewById(R.id.scrollView);
        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        TextView tv = new TextView(this);
        tv.setText("Don't forget to do this today");
        ll.addView(tv);

        String lines[] = data.split("\\r?\\n");
        int idi=0;
        for (String s:lines){
            CheckBox ch = new CheckBox(this);
            ch.setText(s);
            ch.setId(idi++);
            ch.setTextColor(Color.parseColor("#1A237E"));
            ch.setTextSize(24);

            ll.addView(ch);

        }



    }


}
