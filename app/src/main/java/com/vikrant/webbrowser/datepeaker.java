package com.vikrant.webbrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class datepeaker extends AppCompatActivity {
ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datepeaker);
        viewpager=findViewById(R.id.viewPage);
        imageViewAdapter imageadapter=new imageViewAdapter(this);
        viewpager.setAdapter(imageadapter);
    }
}
