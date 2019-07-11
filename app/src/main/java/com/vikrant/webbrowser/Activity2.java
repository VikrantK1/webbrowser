package com.vikrant.webbrowser;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
 SeekBar seek;
 TextView text,text2;
 Button btn1,btn2,btn3;
 DatePicker dp;
 TimePicker tp;
 ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        seek=findViewById(R.id.seekbar);
        text=findViewById(R.id.text1);
        text2=findViewById(R.id.textView2);
        btn1=findViewById(R.id.button);
        dp=findViewById(R.id.datepeaker);
        tp=findViewById(R.id.timepeaker);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);
        pb=findViewById(R.id.progess);
        seekbarfun();
        setDate();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        pb.setMax(100);
    }



    public void seekbarfun()
    {

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               pb.setProgress(i);
                text.setText(""+i);



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
           Toast.makeText(getApplicationContext(),"SeekBar Started",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(),"SeekBar Stop",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void setDate()
    {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dp.setVisibility(View.VISIBLE);
                tp.setVisibility(View.INVISIBLE);
                text2.setText(getDate());
            }
        });
//      dp.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//          @Override
//          public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//
//          }
//      });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(getTime());
              tp.setVisibility(View.VISIBLE);
              dp.setVisibility(View.INVISIBLE);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Activity3.class);
                startActivity(intent);
            }
        });
    }
    public  String getDate()
    {
   StringBuilder build=new StringBuilder();
   build.append(dp.getDayOfMonth()+"/ ").append(dp.getMonth()+"/ ").append(dp.getYear());
   return  build.toString();
    }
    public  String getTime()
    {
        StringBuilder build=new StringBuilder();
        build.append(tp.getHour()+":").append(dp.getMinDate());
        return  build.toString();
    }






}
