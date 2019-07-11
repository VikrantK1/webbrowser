package com.vikrant.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

public class imageSwitcher extends AppCompatActivity {
ImageSwitcher imagesw;
Button btn1,btn2;
Integer counter=0;
Integer []imgid={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        initiaview();
    }
    public void initiaview()
    {
        imagesw=findViewById(R.id.imageSwitcher);
        btn1=findViewById(R.id.nextImage);
        btn2=findViewById(R.id.nextpage);
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               imagesw.setFactory(new ViewSwitcher.ViewFactory() {
                   @Override
                   public View makeView() {
                       ImageView imageView=new ImageView(getApplicationContext());
                       imageView.setLayoutParams(new ImageSwitcher.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
                       imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                       imageView.setImageResource(R.drawable.img10);
                       return imageView;
                   }
               });
               Animation aimateout= AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_out_right);
               Animation aimatein=AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left);
               imagesw.setOutAnimation(aimateout);
               imagesw.setInAnimation(aimatein);
           }
       });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              counter++;
              if (counter==imgid.length)
              {
                  counter=0;
                  imagesw.setImageResource(imgid[counter]);
              }
              else
              {
                  imagesw.setImageResource(imgid[counter]);
              }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(imageSwitcher.this,datepeaker.class);
                startActivity(intent);
            }
        });
    }
    public void viewstub(View v)
    {
        Intent intent =new Intent(getApplicationContext(),viewStub.class);
        startActivity(intent);
    }

}
