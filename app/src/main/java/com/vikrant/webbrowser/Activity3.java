package com.vikrant.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

    }
    public void nextview23(View v)
    {
        Intent intent=new Intent(Activity3.this,imageSwitcher.class);
        startActivity(intent);
    }
}
